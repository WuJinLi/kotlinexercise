package com.wjl.kotlinexercise.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.wjl.kotlinexercise.adapter.BannerListAdapter
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.mvp.presenter.HomePresenter
import com.wjl.kotlinexercise.ui.WebViewDetailActivity
import kotlinx.android.synthetic.main.fg_home.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    var adapter: BannerListAdapter? = null
    override fun setData(bean: List<Banner>) {
        adapter!!.addData(bean)
    }

    override fun setHomeData(bean: HomeBean) {
    }


    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    val mPresenter: HomePresenter by lazy {
        HomePresenter(context!!.applicationContext, this)
    }

    override fun attachLayoutRes() = R.layout.fg_home

    override fun initView() {
        adapter = BannerListAdapter(this!!.activity!!)
        lv_listview.adapter = adapter

        lv_listview.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var banner: Banner = adapter!!.getItem(position) as Banner
                Intent(activity, WebViewDetailActivity::class.java).run {
                    putExtra("url", banner.url)
                    startActivity(this)
                }
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getBannerData()
    }
}