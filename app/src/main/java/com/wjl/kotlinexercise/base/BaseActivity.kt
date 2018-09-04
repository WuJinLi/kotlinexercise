package com.wjl.kotlinexercise.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  :
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutRes())
        initData()
        initViews()
        initListener()
    }


    /**
     * 返回布局id
     */
    protected abstract fun attachLayoutRes():Int


    /**
     * 初始化数据
     */
    protected abstract fun initData():Unit


    /**
     * 初始化布局文件，控件的设置等操作
     */
    protected abstract fun initViews():Unit


    /**
     * 初始化监听事件，包括按钮的点击，单选框的点击，输入框的输入监听事件等
     */

    protected abstract fun initListener():Unit
}