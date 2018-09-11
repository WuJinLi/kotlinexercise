package com.wjl.kotlinexercise.mvp.model

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.http.RetrofitClient
import io.reactivex.Observable

/**
 * @author: wjl
 * @date:2018/9/10
 */
class BannerModel {

    fun getBannerData(context: Context): Observable<BannerList> {
        return RetrofitClient.getInstance(context).create(ApiService::class.java).let { apiService ->
            apiService!!.getBannerData()
        }
    }
}