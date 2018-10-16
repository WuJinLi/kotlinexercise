package com.wjl.kotlinexercise.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.wjl.kotlinexercise.http.LogUtil
import kotlin.properties.Delegates

/**
 * @author: wjl
 * @date:2018/9/6
 */
class App : MultiDexApplication() {
    companion object {
        private val TAG = "App"

        var context: Context by Delegates.notNull()
            private set

        lateinit var instance: Application


    }

    override fun onCreate() {
        super.onCreate()
        LogUtil.init(true)
    }
}