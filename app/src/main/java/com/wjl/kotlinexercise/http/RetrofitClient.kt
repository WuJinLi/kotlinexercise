package com.wjl.kotlinexercise.http

import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.app.App
import com.wjl.kotlinexercise.constant.Constant
import com.wjl.kotlinexercise.utils.NetWorkUtil
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author: wjl
 * @date:2018/9/6
 */
object RetrofitClient {
    private var retrofit: Retrofit? = null


    val service: ApiService by lazy { getRerofit()!!.create(ApiService::class.java) }


    private fun getRerofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitClient::class.java) {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .baseUrl(Constant.BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()

                }
            }
        }

        return retrofit
    }


    private fun getOkHttpClient(): OkHttpClient {
        var builder = OkHttpClient().newBuilder()

        //日志拦截器
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        //设置缓存大小,缓存文件的位置
        var cacheFile = File(App.context.cacheDir, "cache")
        var cache = Cache(cacheFile, 1024 * 1024 * 50)
        builder.run {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(addHttpInterceptor())
            addInterceptor(addCacheInterceptor())
            cache(cache)  //添加缓存
            connectTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true) // 错误重连
        }
        return builder.build()
    }

    private fun addHttpInterceptor(): Interceptor {
        return Interceptor { chain ->
            val builder = chain.request().newBuilder()
            val request = builder.addHeader("Content-type", "application/json; charset=utf-8").build()
            chain.proceed(request)
        }
    }

    private fun addCacheInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            if (!NetWorkUtil.isNetworkAvailable(App.context)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
            }
            val response = chain.proceed(request)
            if (NetWorkUtil.isNetworkAvailable(App.context)) {
                val maxAge = 0
                // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .build()
            } else {
                // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("nyn")
                        .build()
            }
            response
        }
    }
}