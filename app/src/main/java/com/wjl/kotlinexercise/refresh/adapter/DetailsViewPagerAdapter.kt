package com.wjl.kotlinexercise.refresh.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wjl.kotlinexercise.refresh.fragment.AndroidNewsFragment

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class DetailsViewPagerAdapter(val fm: FragmentManager, val titleList: List<String>, val fragmentList: List<Fragment>) : FragmentPagerAdapter(fm) {

    private var mlistTitle = listOf<String>()
    private var mFragmentList = listOf<Fragment>()


    init {
        mlistTitle = titleList
        mFragmentList = fragmentList
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int = mlistTitle.size

    override fun getPageTitle(position: Int): CharSequence? = mlistTitle.get(position)

}