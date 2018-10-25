package com.wjl.kotlinexercise.utils

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.net.ConnectivityManager
import com.wjl.kotlinexercise.app.App
import java.nio.charset.Charset

/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc:
 */

object CommonUtil {
    private val app: Application = App.application

    fun isConnected(): Boolean {
        val cm: ConnectivityManager =
                app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting
    }

    fun getStringFromAssets(
            subdirectory: String,
            fileName: String
    ): String {
        return app.assets.fileAsString(subdirectory, fileName)
    }

    private fun AssetManager.fileAsString(
            subdirectory: String,
            filename: String
    ): String {
        return open("$subdirectory/$filename").use {
            it.readBytes()
                    .toString(Charset.defaultCharset())
        }
    }
}