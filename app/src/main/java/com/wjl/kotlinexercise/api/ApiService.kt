package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.mvp.model.BannerList
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.refresh.GankBeanList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {

    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Observable<HomeBean>

    //http://www.wanandroid.com/
    @GET("banner/json")
    fun getBannerData(): Observable<BannerList>


    @GET("data/{category}/{pagecount}/{page}")
    fun requestData( @Path("category") category: String, @Path("pagecount") countPerPage: Int, @Path("page") page: Int): Observable<GankBeanList>
}