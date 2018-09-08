package com.wjl.kotlinexercise.ui.fragment

import android.os.Bundle
import android.view.View
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fg_home.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment(), HomeContract.View {
    override fun setHomeData(bean: HomeBean) {
        tv_info.text = bean.nextPageUrl
    }

    override fun setData(bean: Banner) {
        tv_info.text = bean.url
    }


    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    val mPresenter: HomePresenter by lazy {
        HomePresenter(context!!.applicationContext, this)
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fg_home
    }

    override fun initView() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getHomeData()
    }
}