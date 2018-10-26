package com.wjl.kotlinexercise.openeye.ui.commonfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.openeye.adapter.HomeDataAdapter
import com.wjl.kotlinexercise.openeye.contract.CommonListContract
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity

/**
 * @author: wujinli
 * @date:2018/10/26
 * @desc: 首页公共fragment
 */
class CommonListFragment : Fragment(), CommonListContract.ICommonListView {

    private var url: String? = null
    private var mContext: Context? = null
    private var commonListPresenter: CommonListPresenter? = null
    private var adapter: HomeDataAdapter? = null
    private var dataSource: MutableList<HomeDataEntity> = ArrayList()


    private var rootView: View? = null
    private var swipe_refresh: SwipeRefreshLayout? = null
    private var recycler_data_list_home: RecyclerView? = null


    companion object {
        fun getInstance(url: String): CommonListFragment {
            return CommonListFragment().apply {
                val bundle: Bundle = Bundle()
                bundle.putString("url", url)
                arguments = bundle
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments!!.getString("url")
        mContext = context
        commonListPresenter = CommonListPresenter(mContext!!, this)
        adapter = HomeDataAdapter(mContext!!, dataSource)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(mContext).inflate(R.layout.fg_common_list, container, false)
        swipe_refresh = rootView!!.findViewById(R.id.swipe_refresh)
        recycler_data_list_home = rootView!!.findViewById(R.id.recycler_data_list_home)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commonListPresenter?.loadData(url!!)
    }


    override fun loadDataSuccessful(homeDataEnity: HomeDataEntity) {
        if (homeDataEnity != null) {

        }
    }

    override fun loadDataFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}