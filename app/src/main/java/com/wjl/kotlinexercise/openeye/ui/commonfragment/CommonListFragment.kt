package com.wjl.kotlinexercise.openeye.ui.commonfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.openeye.adapter.HomeDataAdapter
import com.wjl.kotlinexercise.openeye.contract.CommonListContract
import com.wjl.kotlinexercise.openeye.entity.HomeDataBean
import com.wjl.kotlinexercise.openeye.entity.Item
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity
import com.wjl.kotlinexercise.utils.ToastUtil

/**
 * @author: wujinli
 * @date:2018/10/26
 * @desc: 首页公共fragment
 */
class CommonListFragment : Fragment(), CommonListContract.ICommonListView {

    private var url: String? = null
    private var commonListPresenter: CommonListPresenter? = null
    private var adapter: HomeDataAdapter? = null
    private var dataSource: MutableList<HomeDataEntity> = ArrayList()
    private var nextPageUrl: String? = null


    private var rootView: View? = null
    private var swipe_refresh: SwipeRefreshLayout? = null
    private var recycler_data_list_home: RecyclerView? = null
    private var empty: View? = null
    private var tv_empty: TextView? = null


    companion object {
        fun getInstance(url: String): CommonListFragment {
            return CommonListFragment().apply {
                val bundle = Bundle()
                bundle.putString("url", url)
                arguments = bundle
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        url = arguments!!.getString("url")

        commonListPresenter = CommonListPresenter(requireContext(), this)
        adapter = HomeDataAdapter(activity!!, dataSource)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(requireContext()).inflate(R.layout.fg_common_list, container, false)
        swipe_refresh = rootView!!.findViewById(R.id.swipe_refresh)
        recycler_data_list_home = rootView!!.findViewById(R.id.recycler_data_list_home)

        empty = LayoutInflater.from(requireContext()).inflate(R.layout.ly_empty, container, false)
        tv_empty = empty?.findViewById(R.id.tv_empty)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        swipe_refresh!!.isRefreshing=false
        recycler_data_list_home?.layoutManager = LinearLayoutManager(requireContext())
//        adapter?.setEmptyView(R.layout.ly_empty)
        recycler_data_list_home?.adapter = adapter

        adapter?.openLoadAnimation()

        commonListPresenter?.loadData(url!!)

        tv_empty?.setOnClickListener {
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    ToastUtil._short("加载数据失败")
                }

            }
        }
    }


    /**
     * 加载数据成功
     */
    override fun loadDataSuccessful(homeDataBean: HomeDataBean) {
        if (homeDataBean != null) {
            //返回数据不为空
            nextPageUrl = homeDataBean.nextPageUrl
            dataSource.clear()
            if (homeDataBean.itemList != null) {
                for (item: Item? in homeDataBean.itemList) {
                    when (item?.type) {
                        HomeDataEntity.horizontalScrollCard -> {
                            dataSource.add(HomeDataEntity(HomeDataEntity.TYPE_horizontalScrollCard, item))
                        }
                    }
                }

                adapter?.addData(dataSource)
            }
        } else {
            //返回数据为空
        }
    }


    /**
     * 数据加载失败
     */
    override fun loadDataFailed() {
        //加载数据失败
        ToastUtil._short("加载数据失败")
    }


    /**
     * 设置加载地址，加载指定数据
     */
    fun setUrl(url: String) {
        this.url = url
        if (commonListPresenter == null) {
            commonListPresenter = CommonListPresenter(requireContext(), this)
        }
        commonListPresenter!!.loadData(url)
    }
}