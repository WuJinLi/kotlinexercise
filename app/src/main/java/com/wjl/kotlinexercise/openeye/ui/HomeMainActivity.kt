package com.wjl.kotlinexercise.openeye.ui

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.openeye.adapter.CategroyNavAdapter
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract
import com.wjl.kotlinexercise.openeye.model.AllCategroyModel
import com.wjl.kotlinexercise.openeye.model.CategroyModel
import com.wjl.kotlinexercise.openeye.presenter.HomeMainPresenter
import com.wjl.kotlinexercise.test.HeWeather6Model
import com.wjl.kotlinexercise.ui.MainPageActivity
import kotlinx.android.synthetic.main.ac_home_main.*
import kotlinx.android.synthetic.main.app_bar_home_main.*
import kotlinx.android.synthetic.main.content_home_main.*

class HomeMainActivity : BaseActivity(), HomeMainContract.IHomeViewNavgitionView, View.OnClickListener {


    var homePresenter: HomeMainPresenter? = null
    var categroyNavAdapter:CategroyNavAdapter?=null
    var categroyModelList:MutableList<CategroyModel.ItemListBean>?=null

    override fun attachLayoutRes() = R.layout.ac_home_main

    override fun initData() {
        homePresenter = HomeMainPresenter(mContext, HomeMainActivity@ this)
        categroyNavAdapter= CategroyNavAdapter(mContext)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()



        btn_button.text="获取数据"


        val recyclerview_categroy=nav_view.findViewById<RecyclerView>(R.id.design_navigation_view)
        recyclerview_categroy.layoutManager=LinearLayoutManager(mContext)
        recyclerview_categroy.adapter=categroyNavAdapter

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


    override fun setNavigitionView(heWeather6Model: HeWeather6Model) {
        tv_show.text = Gson().toJson(heWeather6Model)
    }


    override fun loadDataFailed() {
        Toast.makeText(mContext, "数据异常，请退出重试", Toast.LENGTH_SHORT).show()
    }

    override fun showAllCategroyData(allCategroyModel: AllCategroyModel) {
        tv_show.text = Gson().toJson(allCategroyModel)
    }


    override fun showNavigitionCategroy(categroyModel: CategroyModel) {
//        tv_show.text = Gson().toJson(categroyModel)
        categroyNavAdapter!!.setCategroyList(categroyModel!!.itemList!!)
    }

}
