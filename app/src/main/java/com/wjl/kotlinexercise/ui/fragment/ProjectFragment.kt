package com.wjl.kotlinexercise.ui.fragment

import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 项目fragment
 */
class ProjectFragment : BaseFragment() {
    companion object {
        fun getInstance(): ProjectFragment = ProjectFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fg_project
    }

    override fun initView() {
    }
}