package com.wjl.kotlinexercise.ui

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import kotlinx.android.synthetic.main.ac_webview_details.*

/**
 * @author: wjl
 * @date:2018/9/11
 */
class WebViewDetailActivity : BaseActivity() {
    var url:String=""
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
                allowFileAccess=true
                setSupportZoom(true)
                cacheMode = WebSettings.LOAD_NO_CACHE
                domStorageEnabled = true
                databaseEnabled = true
            }
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
        }

        ww_webview.loadUrl(url)
    }

    override fun initListener() {

    }

}