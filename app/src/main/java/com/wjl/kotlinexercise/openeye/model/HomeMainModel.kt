package com.wjl.kotlinexercise.openeye.model

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.http.RetrofitClient
import com.wjl.kotlinexercise.openeye.ApiConstant
import com.wjl.kotlinexercise.openeye.bean.CategroyBean
import io.reactivex.Observable

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  :
 */
class HomeMainModel {
    fun getCategroyData(context: Context):Observable<CategroyBean>{
        return  RetrofitClient.getInstance(context)!!.create(ApiService::class.java).let {
            apiService -> apiService!!.getCategroyData(ApiConstant.categoryUrl)
        }
    }
}