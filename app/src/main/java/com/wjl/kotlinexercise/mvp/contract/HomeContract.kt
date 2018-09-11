package com.wjl.kotlinexercise.mvp.contract

import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.mvp.presenter.IBasePresenter
import com.wjl.kotlinexercise.mvp.view.IBaseView

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */
class HomeContract {
    interface View : IBaseView<Presenter> {
        fun setData(bean: List<Banner>)
        fun setHomeData(bean:HomeBean)
    }

    interface Presenter : IBasePresenter {
        fun getHomeData()
        fun getBannerData()
    }

}