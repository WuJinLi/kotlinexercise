package com.wjl.kotlinexercise.openeye.contract

import com.wjl.kotlinexercise.test.HeWeather6Model

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  :
 */
class HomeMainContract {
    interface IHomeViewNavgitionView {
        fun setNavigitionView(heWeather6Model: HeWeather6Model)
        fun loadDataFailed()
    }

    interface HomePresenter  {
        fun getData()
    }
}