package com.wjl.kotlinexercise.http

import android.content.Context
import android.util.Log
import com.wjl.kotlinexercise.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.CacheControl


/**
 * author: WuJinLi
 * time  : 2018/9/7
 * desc  :
 */
class CacheInterceptor(context: Context) : Interceptor{
    val context = context
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request = chain?.request()
        if (NetworkUtils.isNetConneted(context)) {
            val response = chain?.proceed(request)
            // read from cache for 60 s
            val maxAge = 60
            val cacheControl = request?.cacheControl().toString()
            Log.e("CacheInterceptor", "6s load cahe" + cacheControl)
            Log.i("url", request?.url().toString())
            return response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.header("Cache-Control", "public, max-age=" + maxAge)?.build()
        } else {
            Log.e("CacheInterceptor", " no network load cahe")
            request = request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            val response = chain?.proceed(request)
            //set cahe times is 3 days
            val maxStale = 60 * 60 * 24 * 3
            return response?.newBuilder()?.removeHeader("Pragma")?.removeHeader("Cache-Control")?.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)?.build()
        }
    }

}