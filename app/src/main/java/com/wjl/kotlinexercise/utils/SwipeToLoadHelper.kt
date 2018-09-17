package com.wjl.kotlinexercise.utils

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View


import android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE

/**
 * author: WuJinLi
 * time  : 2018/9/14
 * Describe : 上滑加载更多操作辅助类
 */

class SwipeToLoadHelper(recyclerView: RecyclerView, adapterWrapper: AdapterWrapper) : RecyclerView.OnScrollListener() {

    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager?=null
    private var mListener: LoadMoreListener? = null
    /**
     * 是否正在加载中
     */
    private var mLoading = false
    /**
     * 上拉刷新功能是否开启
     */
    private var mIsSwipeToLoadEnabled = true
    private var mAdapterWrapper:AdapterWrapper?=null

    init {
        mRecyclerView=recyclerView
        mAdapterWrapper=adapterWrapper
        mLayoutManager = mRecyclerView!!.layoutManager

        if (mLayoutManager is GridLayoutManager) {
            mAdapterWrapper!!.setAdapterType(AdapterWrapper.ADAPTER_TYPE_GRID)
            mAdapterWrapper!!.setSpanCount((mLayoutManager as GridLayoutManager).spanCount)
        } else if (mLayoutManager is LinearLayoutManager) {
            mAdapterWrapper!!.setAdapterType(AdapterWrapper.ADAPTER_TYPE_LINEAR)
        }

        // 将OnScrollListener设置RecyclerView
        mRecyclerView!!.addOnScrollListener(this)
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        if (mIsSwipeToLoadEnabled && SCROLL_STATE_IDLE == newState && !mLoading) {
            if (mLayoutManager is GridLayoutManager) {
                val gridLayoutManager = mLayoutManager as GridLayoutManager
                gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (mIsSwipeToLoadEnabled) {
                            // 功能开启, 根据位置判断, 最后一个item时返回整个宽度, 其他位置返回1
                            // AdapterWrapper会保证最后一个item会从新的一行开始
                            if (position == mLayoutManager!!.getItemCount() - 1) {
                                gridLayoutManager.spanCount
                            } else {
                                1
                            }
                        } else {
                            1
                        }
                    }
                }
            }

            if (mLayoutManager is LinearLayoutManager) {
                val linearLayoutManager = mLayoutManager as LinearLayoutManager
                val lastCompletePosition = linearLayoutManager.findLastCompletelyVisibleItemPosition()
                // only when the complete visible item is second last
                if (lastCompletePosition == mLayoutManager!!.getItemCount() - 2) {
                    val firstCompletePosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val child = linearLayoutManager.findViewByPosition(lastCompletePosition)
                            ?: return
                    val deltaY = recyclerView!!.bottom - recyclerView.paddingBottom - child.bottom
                    if (deltaY > 0 && firstCompletePosition != 0) {
                        recyclerView.smoothScrollBy(0, -deltaY)
                    }
                } else if (lastCompletePosition == mLayoutManager!!.getItemCount() - 1) {
                    // 最后一项完全显示, 触发操作, 执行加载更多操作 禁用回弹判断
                    mLoading = true
                    mAdapterWrapper!!.setLoadItemState(true)
                    if (mListener != null) {
                        mListener!!.onLoad()
                    }
                }
            }
        }
    }

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
    }

    /**
     * 设置下拉刷新功能是否开启
     */
    fun setSwipeToLoadEnabled(isSwipeToLoadEnabled: Boolean) {
        if (mIsSwipeToLoadEnabled != isSwipeToLoadEnabled) {
            mIsSwipeToLoadEnabled = isSwipeToLoadEnabled
            mAdapterWrapper!!.setLoadItemVisibility(isSwipeToLoadEnabled)
        }
    }

    /**
     * 设置LoadMore Item为加载完成状态, 上拉加载更多完成时调用
     */
    fun setLoadMoreFinish() {
        mLoading = false
        mAdapterWrapper!!.setLoadItemState(false)
    }

    /**
     * 上拉操作触发时调用的接口
     */
    fun setLoadMoreListener(loadMoreListener: LoadMoreListener) {
        mListener = loadMoreListener;
    }

    interface LoadMoreListener {
        fun onLoad()
    }
}
