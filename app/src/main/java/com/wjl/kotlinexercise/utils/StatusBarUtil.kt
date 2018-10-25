package com.wjl.kotlinexercise.utils

import android.app.Activity
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.support.annotation.ColorRes
import android.util.Log
import android.view.View
import android.view.WindowManager

/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc:
 */
object StatusBarUtil {

    fun setStatusBarColor(
            activity: Activity, @ColorRes statusColorResId: Int, @ColorRes navColorResId: Int,
            needNavigationColor: Boolean = true
    ) {
        try {
            val window = activity.window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                if (VERSION.SDK_INT >= VERSION_CODES.M) {
                    window.statusBarColor = activity.resources.getColor(statusColorResId, activity.theme)
                } else {
                    window.statusBarColor = activity.resources.getColor(statusColorResId)
                }
                if (needNavigationColor) {
                    if (VERSION.SDK_INT >= VERSION_CODES.M) {
                        window.navigationBarColor =
                                activity.resources.getColor(navColorResId, activity.theme)
                    } else {
                        window.navigationBarColor = activity.resources.getColor(navColorResId)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setDarkStatusBar(
            activity: Activity,
            needDarkText: Boolean
    ) {
        if (RomUtil.isFlyme()) {
            FlymeStatusLight(activity, needDarkText)
        } else if (RomUtil.isMIUI()) {
            MIUIStatusLight(activity, needDarkText)
        }
    }

    private fun FlymeStatusLight(
            activity: Activity,
            needDarkText: Boolean
    ) {
        try {
            val window = activity
                    .window
            val layoutParams: WindowManager.LayoutParams = window
                    .attributes
            val darkFlag = WindowManager.LayoutParams::class
                    .java
                    .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
            val meizuFlags = WindowManager.LayoutParams::class
                    .java
                    .getDeclaredField("meizuFlags")
            darkFlag
                    .isAccessible = true
            meizuFlags
                    .isAccessible = true
            val bit = darkFlag
                    .getInt(null)
            var value = meizuFlags
                    .getInt(layoutParams)
            value = if (needDarkText) {
                value or bit
            } else {
                value and bit.inv()
            }
            meizuFlags
                    .setInt(bit, value)
            window
                    .attributes = layoutParams
        } catch (e: Exception) {
            Log.d("FlymeStatusLight", e.toString())
        }
    }

    private fun MIUIStatusLight(
            activity: Activity,
            needDarkText: Boolean
    ) {
        try {
            val window = activity
                    .window
            var darkModeFlag = 0
            val clz = window::class
                    .java
            val layoutParams = Class
                    .forName("android.view.MiuiWindowManager\$LayoutParams")
            val field = layoutParams
                    .getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
            darkModeFlag = field
                    .getInt(layoutParams)
            val extraFieldMethod = clz
                    .getMethod("setExtraFlags", Int::class.java, Int::class.java)
            if (needDarkText) {
                extraFieldMethod
                        .invoke(window, darkModeFlag, darkModeFlag) // 状态栏透明且黑色字体
            } else {
                extraFieldMethod
                        .invoke(window, 0, darkModeFlag) // 清除黑色字体
            }
            // MIUI 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
            if (Build.VERSION.SDK_INT >= 23) {
                activity
                        .window
                        .decorView
                        .systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                activity
                        .window
                        .decorView
                        .systemUiVisibility = View
                        .SYSTEM_UI_FLAG_VISIBLE
            }
        } catch (e: Exception) {
            Log.d("MIUIStatusLight", e.toString())
        }
    }
}