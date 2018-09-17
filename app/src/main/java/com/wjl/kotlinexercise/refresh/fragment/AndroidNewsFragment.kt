package com.wjl.kotlinexercise.refresh.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.refresh.GankBean
import com.wjl.kotlinexercise.refresh.GankBeanList
import com.wjl.kotlinexercise.refresh.adapter.DetailsAdapter
import com.wjl.kotlinexercise.refresh.fragment.contact.DetailsContact
import com.wjl.kotlinexercise.refresh.fragment.presenter.DetailsPresenter
import kotlinx.android.synthetic.main.fg_details.*


/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class AndroidNewsFragment : BaseFragment(), DetailsContact.View {
    private var mPer: DetailsPresenter? = null
    private var mAdapter: DetailsAdapter? = null

    override fun attachLayoutRes(): Int = R.layout.fg_details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPer = DetailsPresenter(context!!, this)
        mAdapter = DetailsAdapter(context!!)
    }

    override fun initView() {

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        mPer!!.refresh()

        swipe_refresh_layout.setOnRefreshListener(refreshListener)
    }


    public fun getInstance(): AndroidNewsFragment {

        AndroidNewsFragment().let {
            return it
        }
    }


    val refreshListener = object : SwipeRefreshLayout.OnRefreshListener {
        override fun onRefresh() {
            //刷新加载最新数据，切禁止刷新最新数据
            mPer!!.refresh()
        }

    }

    //加载完成
    override fun refreshComplite(gankBeanList: List<GankBean>) {
        mAdapter!!.setData(gankBeanList as MutableList<GankBean>)
        swipe_refresh_layout.isRefreshing=false
    }
}