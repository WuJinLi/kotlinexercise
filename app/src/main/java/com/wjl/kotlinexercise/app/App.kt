package com.wjl.kotlinexercise.app

import android.app.Application
import com.wjl.kotlinexercise.http.LogUtil

/**
 * author: WuJinLi
 * time  : 2018/10/16
 * desc  :
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LogUtil.init(true)
    }
}