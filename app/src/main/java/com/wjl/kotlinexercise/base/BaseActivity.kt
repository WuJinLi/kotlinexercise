package com.wjl.kotlinexercise.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.wjl.kotlinexercise.openeye.SpTag

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  :
 */
abstract class BaseActivity : AppCompatActivity() {
    private var sp: SharedPreferences? = null
    protected val mContext:Context=this
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
    protected abstract fun attachLayoutRes(): Int


    /**
     * 初始化数据
     */
    protected abstract fun initData(): Unit


    /**
     * 初始化布局文件，控件的设置等操作
     */
    protected abstract fun initViews(): Unit


    /**
     * 初始化监听事件，包括按钮的点击，单选框的点击，输入框的输入监听事件等
     */

    protected abstract fun initListener(): Unit

    open fun getSp(): SharedPreferences {
        if (sp == null) {
            sp =application.getSharedPreferences(SpTag.defaultSpName, Context.MODE_PRIVATE)
        }
        return sp as SharedPreferences
    }

    open fun isNull(string: String?): Boolean {
        if (TextUtils.isEmpty(string) || "null" == string || " " == string) {
            return true
        }
        return false
    }
}