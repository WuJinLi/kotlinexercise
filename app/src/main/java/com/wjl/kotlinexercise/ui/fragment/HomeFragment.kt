package com.wjl.kotlinexercise.ui.fragment

import android.os.Bundle
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment() {


    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }


    override fun attachLayoutRes() = R.layout.fg_home

    override fun initView() {


    }

}

