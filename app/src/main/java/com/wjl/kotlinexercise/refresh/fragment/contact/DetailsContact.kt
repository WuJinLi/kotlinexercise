package com.wjl.kotlinexercise.refresh.fragment.contact

import com.wjl.kotlinexercise.refresh.GankBean
import com.wjl.kotlinexercise.refresh.GankBeanList

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class DetailsContact {

    interface View {
        fun initDataComplite(gankBeanList: List<GankBean>)
        fun refreshComplite(gankBeanList: List<GankBean>)
        fun loadMoreComplite(gankBeanList: List<GankBean>)
        fun setPageStatus(isLoading:Boolean)
    }


    interface Presenter {
        fun initData()
        fun refresh()
        fun loadMore()
    }
}