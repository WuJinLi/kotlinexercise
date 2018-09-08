package com.wjl.kotlinexercise.mvp.presenter

import android.content.Context
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.HomeModel

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {
    override fun getHomeData() {
        mHomeModel.getHomeData(mContext!!).applySchedulers().subscribe({ homeBean ->
            mView!!.apply {
                setHomeData(homeBean)
            }
        }, { e ->
            e.printStackTrace()
        })
    }

    private var mContext: Context? = null
    private var mView: HomeContract.View? = null


    init {
        mContext = context
        mView = view
    }

    private val mHomeModel: HomeModel by lazy {
        HomeModel()
    }
}