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
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract
import com.wjl.kotlinexercise.openeye.presenter.HomeMainPresenter
import com.wjl.kotlinexercise.test.HeWeather6Model
import com.wjl.kotlinexercise.ui.MainPageActivity
import kotlinx.android.synthetic.main.ac_home_main.*
import kotlinx.android.synthetic.main.app_bar_home_main.*
import kotlinx.android.synthetic.main.content_home_main.*

class HomeMainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HomeMainContract.IHomeViewNavgitionView, View.OnClickListener {

    var homePresenter: HomeMainPresenter? = null

    override fun attachLayoutRes() = R.layout.ac_home_main

    override fun initData() {
        homePresenter = HomeMainPresenter(mContext, HomeMainActivity@ this)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun initListener() {
        btn_button.setOnClickListener(this)
        btn_jump.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
//        when (p0.id) {
//            R.id.btn_jump -> {
//                startActivity(intent.setClass(this@HomeMainActivity,MainPageActivity::class.java))
//                this@HomeMainActivity.finish()
//            }
//
//            R.id.btn_button -> {
//                homePresenter!!.getData()
//            }
//        }


        when (p0) {
            btn_jump -> {
                startActivity(intent.setClass(this@HomeMainActivity, MainPageActivity::class.java))
            }

            btn_button -> {
                homePresenter!!.getData()
            }
        }
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

    override fun setNavigitionView(heWeather6Model: HeWeather6Model) {
        tv_show.text = Gson().toJson(heWeather6Model)
    }


    override fun loadDataFailed() {
        Toast.makeText(mContext, "数据异常，请退出重试", Toast.LENGTH_SHORT).show()
    }
}
