package com.wjl.kotlinexercise.utils

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.text.TextUtils
import android.util.Log
import com.wjl.kotlinexercise.app.App


/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc:
 */

object RomUtil {
    fun isMIUI(): Boolean {
        if (!TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", ""))) {
            return true
        }
        return false
    }

    fun isFlyme(): Boolean {
        if (isInstalledByPkgName("com.meizu.flyme.update")) Log.d("RomUtil", "Flyme ROM")
        return isInstalledByPkgName("com.meizu.flyme.update")
    }

    private fun isInstalledByPkgName(pkgName: String): Boolean {
        var packageInfo: PackageInfo?
        try {
            packageInfo = App.application
                    .packageManager
                    .getPackageInfo(pkgName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            packageInfo = null
        }
        return packageInfo != null
    }

    private fun getSystemProperty(
            key: String,
            defaultValue: String
    ): String {
        try {
            val clz = Class
                    .forName("android.os.SystemProperties")
            val get = clz
                    .getMethod("get", String::class.java, String::class.java)
            return get.invoke(clz, key, defaultValue) as String
        } catch (e: Exception) {
            e
                    .printStackTrace()
        }
        return defaultValue
    }
}