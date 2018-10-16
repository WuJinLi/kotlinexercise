package com.wjl.kotlinexercise.openeye.ui

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.openeye.bean.CategroyBean
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract
import com.wjl.kotlinexercise.openeye.presenter.HomeMainPresenter
import kotlinx.android.synthetic.main.ac_home_main.*
import kotlinx.android.synthetic.main.app_bar_home_main.*
import kotlinx.android.synthetic.main.content_home_main.*

class HomeMainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HomeMainContract.IHomeViewNavgitionView{


    var homePresenter: HomeMainPresenter? =null

    override fun attachLayoutRes() = R.layout.ac_home_main

    override fun initData() {
        homePresenter=HomeMainPresenter(mContext,HomeMainActivity@this)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        btn_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                homePresenter!!.getData()
            }

        })



    }

    override fun initListener() {
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun setNavigitionView(categroyBean: CategroyBean) {
        tv_show.text=categroyBean.itemList.size.toString()
    }


    override fun loadDataFailed() {
        Toast.makeText(mContext,"数据异常，请退出重试",Toast.LENGTH_SHORT).show()
    }
}
