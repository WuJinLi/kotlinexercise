package com.wjl.kotlinexercise.openeye.presenter

import android.content.Context
import com.wjl.kotlinexercise.Constant
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.http.RetrofitClient
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract

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


    override fun getData() {
        RetrofitClient.getInstance(mContext!!).create(ApiService::class.java)!!.getWeatherData(Constant.URL)!!.applySchedulers().subscribe(
                {
                    mView!!.apply {
                        setNavigitionView(heWeather6Model = it)
                    }
                },
                {
                    it.printStackTrace()
                    mView!!.apply {
                        loadDataFailed()
                    }
                }
                ,
                {

                })
    }
}