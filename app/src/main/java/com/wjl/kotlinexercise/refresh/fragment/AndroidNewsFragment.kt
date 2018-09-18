package com.wjl.kotlinexercise.refresh.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.refresh.GankBean
import com.wjl.kotlinexercise.refresh.GankBeanList
import com.wjl.kotlinexercise.refresh.adapter.DetailsAdapter
import com.wjl.kotlinexercise.refresh.fragment.contact.DetailsContact
import com.wjl.kotlinexercise.refresh.fragment.presenter.DetailsPresenter
import com.wjl.kotlinexercise.utils.AdapterWrapper
import com.wjl.kotlinexercise.utils.SwipeToLoadHelper
import kotlinx.android.synthetic.main.fg_details.*
import java.util.*
import java.util.function.DoubleToIntFunction


/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class AndroidNewsFragment : BaseFragment(), DetailsContact.View, SwipeToLoadHelper.LoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private var mPer: DetailsPresenter? = null
    private var mAdapter: DetailsAdapter? = null
    private var warpperAdapter: AdapterWrapper? = null
    private var loadHelper: SwipeToLoadHelper? = null

    override fun attachLayoutRes(): Int = R.layout.fg_details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPer = DetailsPresenter(context!!, this)
        mAdapter = DetailsAdapter(context!!)
        warpperAdapter = AdapterWrapper(mAdapter, context)
    }

    override fun initView() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        //初始化页面数据
        mPer!!.initData()
        //设置刷新数据监听器
        swipe_refresh_layout.setOnRefreshListener(this)

        loadHelper = SwipeToLoadHelper(recycler_view, warpperAdapter!!)
        loadHelper!!.setLoadMoreListener(this)
    }

    public fun getInstance(): AndroidNewsFragment {
        AndroidNewsFragment().let {
            return it
        }
    }

    override fun onRefresh() {
        //刷新加载最新数据，切禁止刷新最新数据
        mPer!!.refresh()
        loadHelper!!.setSwipeToLoadEnabled(false)
    }

    //初始化数据完成
    override fun initDataComplite(gankBeanList: List<GankBean>) {
        mAdapter!!.setData(gankBeanList as MutableList<GankBean>)
    }

    //刷新数据完成
    override fun reFreshComplite(gankBeanList: List<GankBean>) {
        mAdapter!!.setData(gankBeanList as MutableList<GankBean>)
        swipe_refresh_layout.isRefreshing = false
        loadHelper!!.setSwipeToLoadEnabled(true)
    }

    override fun loadMoreComplite(gankBeanList: List<GankBean>) {
        mAdapter!!.setData(gankBeanList as MutableList<GankBean>)
        swipe_refresh_layout.isEnabled = true
        loadHelper!!.setLoadMoreFinish()
        warpperAdapter!!.notifyDataSetChanged()
    }


    //加载更多
    override fun onLoad() {
        swipe_refresh_layout.isEnabled = false
        mPer!!.loadMore()
    }


    override fun setPageStatus(isLoading: Boolean) {
        loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        swipe_refresh_layout.visibility = if (isLoading) View.GONE else View.VISIBLE
    }
}