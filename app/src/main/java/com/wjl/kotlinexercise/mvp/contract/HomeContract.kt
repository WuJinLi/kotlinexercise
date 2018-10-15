package com.wjl.kotlinexercise.mvp.contract

import com.wjl.kotlinexercise.mvp.model.Article
import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.presenter.IBasePresenter
import com.wjl.kotlinexercise.mvp.view.IBaseView

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */
class HomeContract {
    interface View {
        fun setData(bean: List<Banner>)
        fun setArticles(articleList: List<Article>)
    }

    interface Presenter : IBasePresenter {
        fun getBannerData()
        fun getArticles(pageNum: Int)
    }

}