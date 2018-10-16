package com.wjl.kotlinexercise.openeye.contract

import com.wjl.kotlinexercise.mvp.presenter.IBasePresenter
import com.wjl.kotlinexercise.mvp.view.IBaseView
import com.wjl.kotlinexercise.openeye.bean.CategroyBean

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  :
 */
class HomeMainContract {
    interface IHomeViewNavgitionView :IBaseView {
        fun setNavigitionView(categroyBean: CategroyBean)
        fun loadDataFailed()
    }

    interface HomePresenter : IBasePresenter {
        fun getData()
    }
}