package com.wjl.kotlinexercise.refresh.fragment.contact

import com.wjl.kotlinexercise.refresh.GankBeanList

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class DetailsContact {

    interface View {
        fun refreshComplite(gankBeanList: GankBeanList)
    }


    interface Presenter {
        fun refresh(category: String)
    }
}