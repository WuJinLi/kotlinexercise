package com.wjl.kotlinexercise.openeye.ui

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.openeye.SpTag
import kotlinx.android.synthetic.main.ac_welcome.*

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  : 欢迎界面
 */
class WelcomeActivity : BaseActivity() {

    override fun attachLayoutRes(): Int = R.layout.ac_welcome

    val handle: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            when (msg?.what) {
                1 -> {
                    startActivity(intent.setClass(this@WelcomeActivity, HomeMainActivity::class.java))
                    this@WelcomeActivity?.finish()
                }
            }
        }
    }

    override fun initData() {

    }

    override fun initViews() {
        //获取每日推荐图片地址，如果没有缓存就加载默认图片
        var imagePath = getSp().getString(SpTag.splashNextPageUrl, "")

        if (!isNull(imagePath)) {
            Glide.with(this).load(imagePath).into(iv_welcome_bg)
        } else {
            Glide.with(this).load(R.raw.welcome_bg).into(iv_welcome_bg)
        }

        val scaleAnimation = ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 3000
        scaleAnimation.fillAfter = true

        iv_welcome_bg.startAnimation(scaleAnimation)

        handle?.sendEmptyMessageDelayed(1, 3500)
    }

    override fun initListener() {

    }
}