package com.wjl.kotlinexercise.ui

import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.ac_main_page.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  :
 */
class MainPageActivity : BaseActivity() {

    override fun attachLayoutRes(): Int = R.layout.ac_main_page

    override fun initData() {
    }

    override fun initViews() {
        BottomNavigationViewHelper.disableShiftMode(bottomnavigationview)
    }

    override fun initListener() {
    }
}