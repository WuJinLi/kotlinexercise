package com.wjl.kotlinexercise.ui.fragment

import android.view.View
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import kotlinx.android.synthetic.main.fg_know_ledge_tree.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  :
 */
class KnowledgeTreeFragment : BaseFragment() {
    companion object {
        fun getInstance(): KnowledgeTreeFragment = KnowledgeTreeFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fg_know_ledge_tree
    }

    override fun initView() {
        tv_know.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }

        })
    }
}