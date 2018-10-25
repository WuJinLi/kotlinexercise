package com.wjl.kotlinexercise.utils

import android.os.Handler
import android.os.Looper
import android.widget.Toast

/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc:
 */

object ToastUtil {

    private var toast: Toast? = null
    private val handler: Handler = Handler(Looper.getMainLooper())

    fun _short(string: String) {
        handler
                .post {
                    if (toast == null) {
                        toast = Toast
                                .makeText(UIUtil.getAppContext(), string, Toast.LENGTH_SHORT)
                        toast
                                ?.show()
                    } else {
                        toast
                                ?.setText(string)
                        toast
                                ?.duration = Toast
                                .LENGTH_SHORT
                        toast
                                ?.show()
                    }
                }
    }

    fun _long(string: String) {
        handler
                .post {
                    if (toast == null) {
                        toast = Toast
                                .makeText(UIUtil.getAppContext(), string, Toast.LENGTH_LONG)
                        toast
                                ?.show()
                    } else {
                        toast
                                ?.setText(string)
                        toast
                                ?.duration = Toast
                                .LENGTH_LONG
                        toast
                                ?.show()
                    }
                }
    }
}