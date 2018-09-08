package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.mvp.model.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {

    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Observable<HomeBean>
}