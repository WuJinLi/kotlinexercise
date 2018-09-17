package com.wjl.kotlinexercise.refresh.fragment.presenter

import android.content.Context
import com.wjl.kotlinexercise.Constant
import com.wjl.kotlinexercise.applySchedulers
import com.wjl.kotlinexercise.refresh.GankBean
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
    private var mList = mutableListOf<GankBean>()

    init {
        mContext = context
        mView = view
    }

    private val gankBeanListModel: GankBeanListModel by lazy {
        GankBeanListModel()
    }


    override fun initData() {
        mCurrentPage = 1
        loadData(Constant.REQUEST_INIT)
    }

    //刷新数据
    override fun refresh() {
        mCurrentPage = 1
        loadData(Constant.REQUEST_REFRESH)
    }


    //加载更多
    override fun loadMore() {
        mCurrentPage++
        loadData(Constant.REQUEST_LOAD_MORE)
    }


    /**
     * 加载数据
     */
    private fun loadData(requestType: Int) {
        gankBeanListModel.loadData(mContext!!, "Android", 20, mCurrentPage).applySchedulers().subscribe({ gankBeanListModel ->
            //            mView?.refreshComplite(gankBeanListModel.results)
            when (requestType) {
                0 ->
                    mView!!.run {
                        mList.run {
                            clear()
                            addAll(gankBeanListModel.results)
                        }
                        initDataComplite(mList)
                        setPageStatus(false)
                    }

                1 ->
                    mView!!.run {
                        mList.run {
                            clear()
                            addAll(gankBeanListModel.results)
                        }
                        refreshComplite(mList)
                    }

                2 ->
                    mView!!.run {
                        mList.run {
                            addAll(gankBeanListModel.results)
                        }
                        loadMoreComplite(mList)
                    }
            }
        })
    }


}