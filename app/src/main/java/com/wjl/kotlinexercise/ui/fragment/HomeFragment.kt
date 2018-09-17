package com.wjl.kotlinexercise.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.adapter.BannerListAdapter
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.model.HomeBean
import com.wjl.kotlinexercise.mvp.presenter.HomePresenter
import com.wjl.kotlinexercise.ui.WebViewDetailActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fg_home.*
import kotlinx.android.synthetic.main.fg_home.view.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    private var adapter: BannerListAdapter? = null
    /**
     * banner datas
     */
    private lateinit var bannerDatas: ArrayList<Banner>

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    val mPresenter: HomePresenter by lazy {
        HomePresenter(context!!.applicationContext, this)
    }

    override fun attachLayoutRes() = R.layout.fg_home

    override fun initView() {
        adapter = BannerListAdapter(this!!.activity!!)
        lv_listview.adapter = adapter

        lv_listview.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var banner: Banner = adapter!!.getItem(position) as Banner
                Intent(activity, WebViewDetailActivity::class.java).run {
                    putExtra("url", banner.url)
                    startActivity(this)
                }
            }

        })

        br_banner.run {
            setDelegate(bannerDelegate)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        mPresenter.getBannerData()
    }


    override fun setData(banners: List<Banner>) {
//        adapter!!.addData(bean)
        bannerDatas = banners as ArrayList<Banner>
        val bannerFeedList = ArrayList<String>()
        val bannerTitleList = ArrayList<String>()
        Observable.fromIterable(banners)
                .subscribe({ list ->
                    bannerFeedList.add(list.imagePath)
                    bannerTitleList.add(list.title)
                })

        br_banner?.run {
            setAutoPlayAble(bannerFeedList.size > 1)
            setData(bannerFeedList, bannerTitleList)
            setAdapter(bannerAdapter)
        }
    }

    override fun setHomeData(bean: HomeBean) {
    }

    /**
     * Banner Adapter
     */
    private val bannerAdapter: BGABanner.Adapter<ImageView, String> by lazy {
        BGABanner.Adapter<ImageView, String> { bgaBanner, imageView, feedImageUrl, position ->
            Glide.with(activity!!).load(feedImageUrl).into(imageView)
        }
    }

    /**
     * BannerClickListener
     */
    private val bannerDelegate = BGABanner.Delegate<ImageView, String> { banner, imageView, model, position ->
        if (bannerDatas.size > 0) {
            val data = bannerDatas[position]
            Intent(activity, WebViewDetailActivity::class.java).run {
                putExtra("url", data.url)
                startActivity(this)
            }
        }
    }
}