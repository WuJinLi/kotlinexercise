package com.wjl.kotlinexercise.ui

import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import kotlinx.android.synthetic.main.ac_webview_details.*
import kotlin.math.log

/**
 * @author: wjl
 * @date:2018/9/11
 */
class WebViewDetailActivity : BaseActivity() {
    private var url: String = ""


    companion object {
        val TAG = WebViewDetailActivity::class.java.simpleName
    }

    override fun attachLayoutRes(): Int = R.layout.ac_webview_details

    override fun initData() {
        url = intent.getStringExtra("url") as String;
    }

    override fun initViews() {
        ww_webview!!.run {
            var webSettings = this.settings
            webSettings.run {
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = true
                allowContentAccess = true
                allowFileAccess = true
                setSupportZoom(true)
                cacheMode = WebSettings.LOAD_NO_CACHE
                domStorageEnabled = true
                databaseEnabled = true
            }
            webChromeClient = wcClient
            webViewClient = wvClient
            setOnKeyListener(onKeyEvent)
        }

        ww_webview.loadUrl(url)
    }

    override fun initListener() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private val onKeyEvent = View.OnKeyListener { v, keyCode, event ->
        val action = event.action
        val webview = v as WebView
        if (KeyEvent.ACTION_DOWN == action && KeyEvent.KEYCODE_BACK == keyCode) {
            if (webview?.canGoBack()) {
                webview.goBack()
                return@OnKeyListener true
            }
        }
        false
    }

    private val wcClient = object : WebChromeClient() {

    }

    private val wvClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            Log.e(TAG, url)
            return false
        }
    }
}