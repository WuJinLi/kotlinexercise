package com.wjl.kotlinexercise.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.widget.AbsListView
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.adapter.ArticlesAdapter
import com.wjl.kotlinexercise.base.BaseFragment
import com.wjl.kotlinexercise.mvp.contract.HomeContract
import com.wjl.kotlinexercise.mvp.model.Article
import com.wjl.kotlinexercise.mvp.model.Banner
import com.wjl.kotlinexercise.mvp.presenter.HomePresenter
import com.wjl.kotlinexercise.ui.WebViewDetailActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fg_home.*
import kotlinx.android.synthetic.main.ly_footview.*

/**
 * author: WuJinLi
 * time  : 2018/9/4
 * desc  : 首页fragment
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    /**
     * banner datas
     */
    private lateinit var bannerDatas: ArrayList<Banner>
    private var articlesAdapter: ArticlesAdapter? = null
    private var isRefresh = true
    private var pagemun = 0

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    val mPresenter: HomePresenter by lazy {
        HomePresenter(context!!.applicationContext, this)
    }

    override fun attachLayoutRes() = R.layout.fg_home

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {


        articlesAdapter = ArticlesAdapter(activity!!)
        lv_listview.adapter = articlesAdapter
        lv_listview.addHeaderView(View.inflate(activity, R.layout.ly_footview, null))

        br_banner.run {
            setDelegate(bannerDelegate)
        }

        swipeRefreshLayout.run {
            isRefreshing = true
            setOnRefreshListener(onRefreshListener)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getBannerData()
        mPresenter.getArticles(0)
        mPresenter.getBannerData()
    }


    //设置轮播图信息
    override fun setData(banners: List<Banner>) {
        bannerDatas = banners as ArrayList<Banner>
        val bannerFeedList = ArrayList<String>()
        val bannerTitleList = ArrayList<String>()

        //对数据类型进行分类和分装
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

    //设置文章列表信息
    override fun setArticles(articleList: List<Article>) {
        isRefresh = false
        swipeRefreshLayout.isRefreshing = false
        articlesAdapter!!.addData(articleList)
    }


    //初始化轮播图adapter
    private val bannerAdapter: BGABanner.Adapter<ImageView, String> by lazy {
        BGABanner.Adapter<ImageView, String> { bgaBanner, imageView, feedImageUrl, position ->
            Glide.with(activity!!).load(feedImageUrl).into(imageView)
        }
    }


    //轮播图点点击事件处理
    private val bannerDelegate = BGABanner.Delegate<ImageView, String> { banner, imageView, model, position ->
        if (bannerDatas.size > 0) {
            val data = bannerDatas[position]
            Intent(activity, WebViewDetailActivity::class.java).run {
                putExtra("url", data.url)
                startActivity(this)
            }
        }
    }


    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        isRefresh = true
        pagemun = 0
        mPresenter.getArticles(pagemun)
    }
}

