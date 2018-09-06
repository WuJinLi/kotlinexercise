package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.model.Banner
import com.wjl.kotlinexercise.model.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {
    @GET("banner/json")
    fun getBanners(): Observable<HttpResult<List<Banner>>>
}