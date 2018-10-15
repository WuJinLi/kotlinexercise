package com.wjl.kotlinexercise.openeye.presenter

import android.content.Context
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.mvp.view.IBaseView
import com.wjl.kotlinexercise.openeye.bean.CategroyBean
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract
import com.wjl.kotlinexercise.openeye.model.HomeMainModel

/**
 * author: WuJinLi
 * time  : 2018/10/15
 * desc  :
 */
class HomeMainPresenter(context: Context, view: HomeMainContract.IHomeViewNavgitionView) : HomeMainContract.HomePresenter {

    var mContext: Context? = null
    var mView: HomeMainContract.IHomeViewNavgitionView? = null

    init {
        mContext = context
        mView = view
    }

    val homeMainModel: HomeMainModel by lazy {
        HomeMainModel()
    }

    override fun getData() {
        homeMainModel.getCategroyData(mContext!!).applySchedulers().subscribe({ categroy: CategroyBean? ->
            mView!!.setNavigitionView(categroy!!)
        },
                {

                }
                , {

        }
        )
    }
}