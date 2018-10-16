package com.wjl.kotlinexercise.http

import okhttp3.logging.HttpLoggingInterceptor

/**
 * author: WuJinLi
 * time  : 2018/10/16
 * desc  :
 */
class HttpLogger : HttpLoggingInterceptor.Logger {
    private val mMessage = StringBuilder()

    override fun log(message: String) {
        var message = message
        // 请求或者响应开始
        if (message.startsWith("--> POST")) {
            mMessage.setLength(0)
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if ((message.startsWith("{") && message.endsWith("}")) || (message.startsWith("[") && message.endsWith("]"))) {
            message = JsonUtil.formatJson(message)
        }
        mMessage.append(message + "\n")
        // 请求或者响应结束，打印整条日志
        if (message.startsWith("<-- END HTTP")) {
            LogUtil.d(mMessage.toString())
        }
    }
}
