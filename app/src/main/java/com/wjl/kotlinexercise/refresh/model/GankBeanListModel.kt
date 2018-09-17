package com.wjl.kotlinexercise.refresh.model

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.http.RetrofitClient
import com.wjl.kotlinexercise.refresh.GankBeanList
import io.reactivex.Observable

/**
 * author: WuJinLi
 * time  : 2018/9/17
 * desc  :
 */
class GankBeanListModel {

    fun loadData(context: Context, category: String, countPerPage: Int, page: Int): Observable<GankBeanList> {
        var url = "https://gank.io/api/data/" + category + "/" + countPerPage + "/" + page
        return RetrofitClient.getInstance(context).create(ApiService::class.java)!!.requestData(url)
    }
}