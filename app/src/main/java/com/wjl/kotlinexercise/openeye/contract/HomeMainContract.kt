package com.wjl.kotlinexercise.openeye.contract

import com.wjl.kotlinexercise.openeye.model.AllCategroyModel
import com.wjl.kotlinexercise.openeye.model.CategroyModel
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
        fun showAllCategroyData(allCategroyModel: AllCategroyModel)
        fun showNavigitionCategroy(categroyModel: CategroyModel)
    }

    interface HomePresenter  {
        fun getData()
    }
}