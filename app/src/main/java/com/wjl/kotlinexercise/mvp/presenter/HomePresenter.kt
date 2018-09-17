package com.wjl.kotlinexercise.mvp.presenter

import android.content.Context
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.ArticlesModle
import com.wjl.kotlinexercise.mvp.model.BannerModel

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  :
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {
    private var mContext: Context? = null
    private var mView: HomeContract.View? = null

    init {
        mContext = context
        mView = view
    }

    private val mBannerModel: BannerModel by lazy {
        BannerModel()
    }

    private val mArticlesModel: ArticlesModle by lazy {
        ArticlesModle()
    }


    override fun getBannerData() {
        mBannerModel.getBannerData(mContext!!).applySchedulers().subscribe({
            mView!!.apply {
                setData(it.data)
            }
        })
    }

    override fun getArticles(pageNum: Int) {
        mArticlesModel.getArticles(mContext!!, pageNum).applySchedulers().subscribe({
            mView!!.apply {
                setArticles(it.data.datas)
            }
        })
    }
}