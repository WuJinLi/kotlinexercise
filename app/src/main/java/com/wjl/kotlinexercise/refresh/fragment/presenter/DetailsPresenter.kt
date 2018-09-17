package com.wjl.kotlinexercise.refresh.fragment.presenter

import android.content.Context
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.refresh.fragment.contact.DetailsContact
import com.wjl.kotlinexercise.refresh.model.GankBeanListModel

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class DetailsPresenter(context: Context, view: DetailsContact.View) : DetailsContact.Presenter {
    private var mCurrentPage: Int = 0
    private var mContext: Context? = null
    private var mView: DetailsContact.View? = null

    init {
        mContext = context
        mView = view
    }

    private val gankBeanListModel: GankBeanListModel by lazy {
        GankBeanListModel()
    }


    override fun refresh() {
        mCurrentPage = 0
        gankBeanListModel.loadData(mContext!!, "Android", 20, mCurrentPage).applySchedulers().subscribe({gankBeanListModel->
            mView?.refreshComplite(gankBeanListModel.results)
        })
    }
}