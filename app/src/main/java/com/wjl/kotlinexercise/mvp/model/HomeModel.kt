package com.wjl.kotlinexercise.mvp.model

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.http.RetrofitClient
import io.reactivex.Observable

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */
class HomeModel {

    fun getHomeData(context: Context): Observable<HomeBean> {
        return RetrofitClient.getInstance(context).create(ApiService::class.java).let {
            it!!.getHomeData()
        }
    }
}