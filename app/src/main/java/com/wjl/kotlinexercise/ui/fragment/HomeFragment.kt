package com.wjl.kotlinexercise.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.http.RetrofitClient
import io.reactivex.Scheduler

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment() {
    companion object {
        fun getInstance():HomeFragment=HomeFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fg_home
    }

    override fun initView() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}