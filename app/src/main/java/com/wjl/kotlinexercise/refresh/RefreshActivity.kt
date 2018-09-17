package com.wjl.kotlinexercise.refresh

import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.refresh.adapter.DetailsViewPagerAdapter
import kotlinx.android.synthetic.main.ac_refresh.*

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class RefreshActivity : BaseActivity() {

    val arr= listOf<String>("Android","福利")
    var detailsViewPagerAdapter:DetailsViewPagerAdapter?=null

    override fun attachLayoutRes(): Int = R.layout.ac_refresh

    override fun initData() {
        detailsViewPagerAdapter= DetailsViewPagerAdapter(supportFragmentManager,arr)
    }

    override fun initViews() {
        vp_viewpager.adapter=detailsViewPagerAdapter
        tb_tab.setupWithViewPager(vp_viewpager)
    }

    override fun initListener() {

    }
}