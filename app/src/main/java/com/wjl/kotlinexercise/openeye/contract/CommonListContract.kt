package com.wjl.kotlinexercise.openeye.contract

import com.wjl.kotlinexercise.openeye.entity.HomeDataBean
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity

/**
 * @author: wujinli
 * @date:2018/10/26
 * @desc: 公共fragment的contract类
 */
class CommonListContract {

    interface ICommonListView {
        fun loadDataSuccessful(homeDataBean: HomeDataBean)
        fun loadDataFailed()
    }


    interface IPresenter {
        fun loadData(url:String)
    }

}