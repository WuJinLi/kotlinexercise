package com.wjl.kotlinexercise.openeye.ui.commonfragment

import android.content.Context
import com.wjl.kotlinexercise.api.ApiService
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.http.RetrofitClient
import com.wjl.kotlinexercise.openeye.contract.CommonListContract
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity

/**
 * @author: wujinli
 * @date:2018/10/26
 * @desc:
 */
class CommonListPresenter : CommonListContract.IPresenter {


    private var context: Context
    private var apiService: ApiService
    private var mView: CommonListContract.ICommonListView

    constructor(context: Context, mView: CommonListContract.ICommonListView) {
        this.context = context
        this.mView = mView
        apiService = RetrofitClient.getInstance(context).create(ApiService::class.java)!!
    }


    override fun loadData(url: String) {
        apiService.getCommonListData(url).applySchedulers().subscribe(
                { homeDataEnity: HomeDataEntity? ->
                    mView.apply {
                        loadDataSuccessful(homeDataEnity!!)
                    }
                },
                { t: Throwable? ->
                    mView.apply {
                        loadDataFailed()
                    }
                }

        )
    }

}