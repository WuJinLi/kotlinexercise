package com.wjl.kotlinexercise.http

import com.orhanobut.logger.LogLevel
import com.orhanobut.logger.Logger

/**
 * author: WuJinLi
 * time  : 2018/10/16
 * desc  :
 */
object LogUtil {
    /**
     * 初始化log工具，在app入口处调用
     *
     * @param isLogEnable 是否打印log
     */
    fun init(isLogEnable: Boolean) {
        Logger.init("LogHttpInfo")
                .hideThreadInfo()
                .logLevel(if (isLogEnable) LogLevel.FULL else LogLevel.NONE)
                .methodOffset(2)
    }

    fun d(message: String) {
        Logger.d(message)
    }

    fun i(message: String) {
        Logger.i(message)
    }

    fun w(message: String, e: Throwable?) {
        val info = e?.toString() ?: "null"
        Logger.w("$message：$info")
    }

    fun e(message: String, e: Throwable) {
        Logger.e(e, message)
    }

    fun json(json: String) {
        Logger.json(json)
    }
}
