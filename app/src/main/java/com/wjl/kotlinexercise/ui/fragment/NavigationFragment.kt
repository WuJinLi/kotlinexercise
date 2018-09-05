package com.wjl.kotlinexercise.ui.fragment

import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 导航fragment
 */
class NavigationFragment: BaseFragment() {


        companion object {
            fun getInstance():NavigationFragment= NavigationFragment()
        }

    override fun attachLayoutRes(): Int {
        return R.layout.fg_navigation
    }

    override fun initView() {
    }
}