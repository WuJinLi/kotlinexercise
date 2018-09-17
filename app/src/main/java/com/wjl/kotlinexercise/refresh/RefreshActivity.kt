package com.wjl.kotlinexercise.refresh

import android.support.v4.app.Fragment
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.refresh.adapter.DetailsViewPagerAdapter
import com.wjl.kotlinexercise.refresh.fragment.AndroidNewsFragment
import com.wjl.kotlinexercise.refresh.fragment.BeautifulGirlFragment
import kotlinx.android.synthetic.main.ac_refresh.*

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class RefreshActivity : BaseActivity() {

    val arr = listOf<String>("Android", "福利")
    val fragmentArr = mutableListOf<Fragment>()
    var detailsViewPagerAdapter: DetailsViewPagerAdapter? = null
    var androidNewFragment: AndroidNewsFragment? = null
    var beautifulGirlFragment: BeautifulGirlFragment? = null

    override fun attachLayoutRes(): Int = R.layout.ac_refresh

    init {
        if (androidNewFragment == null) {
            androidNewFragment = AndroidNewsFragment()
        }

        if (beautifulGirlFragment == null) {
            beautifulGirlFragment = BeautifulGirlFragment()
        }

        fragmentArr.add(androidNewFragment!!)
        fragmentArr.add(beautifulGirlFragment!!)
    }

    override fun initData() {
        detailsViewPagerAdapter = DetailsViewPagerAdapter(supportFragmentManager, arr, fragmentArr)
    }

    override fun initViews() {
        vp_viewpager.adapter = detailsViewPagerAdapter
        tb_tab.setupWithViewPager(vp_viewpager)
    }

    override fun initListener() {

    }
}