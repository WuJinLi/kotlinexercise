package com.wjl.kotlinexercise.openeye.ui

import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wjl.kotlinexercise.Constant
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseActivity
import com.wjl.kotlinexercise.openeye.adapter.CategroyNavAdapter
import com.wjl.kotlinexercise.openeye.contract.HomeMainContract
import com.wjl.kotlinexercise.openeye.model.AllCategroyModel
import com.wjl.kotlinexercise.openeye.model.CategroyModel
import com.wjl.kotlinexercise.openeye.presenter.HomeMainPresenter
import com.wjl.kotlinexercise.openeye.ui.commonfragment.CommonListFragment
import com.wjl.kotlinexercise.test.HeWeather6Model
import kotlinx.android.synthetic.main.ac_home_main.*
import kotlinx.android.synthetic.main.app_bar_home_main.*

class HomeMainActivity : BaseActivity(), HomeMainContract.IHomeViewNavgitionView, View.OnClickListener {


    private var homePresenter: HomeMainPresenter? = null
    private var categroyNavAdapter: CategroyNavAdapter? = null
    private var commonListFragment: CommonListFragment? = null

    override fun attachLayoutRes() = R.layout.ac_home_main

    override fun initData() {
        homePresenter = HomeMainPresenter(mContext, HomeMainActivity@ this)
        categroyNavAdapter = CategroyNavAdapter(mContext)
    }

    override fun initViews() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        recycler_view_nav.layoutManager = LinearLayoutManager(mContext)
        recycler_view_nav.adapter = categroyNavAdapter


        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()

        commonListFragment = CommonListFragment.getInstance(Constant.DISCOVERY_URL)
        beginTransaction.add(R.id.fl_container, commonListFragment!!)
        beginTransaction.commit()

        homePresenter?.getData()


    }

    override fun initListener() {
        categroyNavAdapter?.setOnItemClickListener(object : CategroyNavAdapter.ItemClicListener {
            override fun onClick(view: View, position: Int) {
                var item: CategroyModel.ItemListBean = categroyNavAdapter?.getCategroyList()?.get(position)!!
                var itemType = item.data?.follow?.itemType
                var itemId = item.data?.follow?.itemId
                var url: String? = null
                if (itemType.equals("categroy")) {
                    url = Constant.API_PREFIX_URL + itemType + "/" + itemId
                }
                commonListFragment?.setUrl(url!!)
            }
        })


    }


    override fun onResume() {
        super.onResume()
        commonListFragment?.setUrl(Constant.DISCOVERY_URL)
    }

    override fun loadData() {
    }


    override fun onClick(p0: View?) {
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun setNavigitionView(heWeather6Model: HeWeather6Model) {
//        tv_show.text = Gson().toJson(heWeather6Model)
    }


    override fun loadDataFailed() {
//        Toast.makeText(mContext, "数据异常，请退出重试", Toast.LENGTH_SHORT).show()
    }

    override fun showAllCategroyData(allCategroyModel: AllCategroyModel) {
//        tv_show.text = Gson().toJson(allCategroyModel)
    }


    override fun showNavigitionCategroy(categroyModel: CategroyModel) {
//        tv_show.text = Gson().toJson(categroyModel)
        categroyNavAdapter!!.setCategroyList(categroyModel!!.itemList!!)
    }

}
