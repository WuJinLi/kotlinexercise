package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.mvp.model.ArticleResponse
import com.wjl.kotlinexercise.mvp.model.BannerList
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.refresh.GankBeanList
import com.wjl.kotlinexercise.mvp.model.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {


    /**
     * 轮播图
     */
    //http://www.wanandroid.com/
    @GET("banner/json")
    fun getBannerData(): Observable<BannerList>


    /**
     * 获取文章信息列表
     */
    @GET("article/list/{pageNum}/json")
    fun getArticle(@Path("pageNum") pageNum: Int): Observable<HttpResult<ArticleResponse>>


    @GET()
    fun requestData(@Url() url: String): Observable<GankBeanList>
}