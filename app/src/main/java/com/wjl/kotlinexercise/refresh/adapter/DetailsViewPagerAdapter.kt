package com.wjl.kotlinexercise.refresh.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wjl.kotlinexercise.refresh.fragment.DetailsFragment

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * desc  :
 */
class DetailsViewPagerAdapter(val fm: FragmentManager, val titleList: List<String>) : FragmentPagerAdapter(fm) {

    var mlistTitle= listOf<String>()


    init {
        mlistTitle = titleList
    }

    override fun getItem(position: Int): Fragment {
        return DetailsFragment().getInstance(mlistTitle.get(position))
    }

    override fun getCount(): Int = mlistTitle.size

    override fun getPageTitle(position: Int): CharSequence? = mlistTitle.get(position)

}