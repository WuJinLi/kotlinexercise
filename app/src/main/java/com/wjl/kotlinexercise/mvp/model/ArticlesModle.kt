package com.wjl.kotlinexercise.mvp.model

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.http.RetrofitClient
import io.reactivex.Observable

/**
 * @author: wjl
 * @date:2018/9/12
 */
class ArticlesModle {

    fun getArticles(context: Context, pageNum: Int): Observable<HttpResult<ArticleResponse>> {
        return RetrofitClient.getInstance(context).create(ApiService::class.java)!!.getArticle(pageNum)
    }
}