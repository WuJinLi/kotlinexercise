package com.wjl.kotlinexercise.openeye.holder

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseViewHolder
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.openeye.adapter.HorRvAdapter
import com.wjl.kotlinexercise.openeye.entity.Item
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity
import com.wjl.kotlinexercise.widget.HorRvDecoration

/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc: 横向recyclerview布局显示 通过BaseViewHolder，HomeDataEntity进行指定数据的展示
 *        当前展示数据的意图就是通过holder获取当前父布局某一item，进行多布局中某一种布局数据的展示
 */
class HorizontalScrollCard {

    //声明数据
    private var context: Context
    private var helper: BaseViewHolder
    private var entity: HomeDataEntity



    //业务数据和view控件
    private var list: MutableList<Item?> = mutableListOf()
    private lateinit var adapter: HorRvAdapter
    private lateinit var manager: LinearLayoutManager
    private lateinit var snapHelper: PagerSnapHelper

    constructor(context: Context, helper: BaseViewHolder, entity: HomeDataEntity) {
        this.context = context
        this.helper = helper
        this.entity = entity
        //展示数据
        setData()
    }

    /**
     * 展示业务数据
     */
    private fun setData() {

        if (entity.getItem()?.data?.itemList == null) return

        val recyclerview = helper.getView<RecyclerView>(R.id.rv_horizontalScrollCard)
        manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = manager

        snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerview)
        if (list.size > 0) {
            list.clear()
        }

        list.addAll(entity.getItem()?.data?.itemList!!)
        adapter = HorRvAdapter(context, list)

        recyclerview.adapter = adapter

        val decoration = HorRvDecoration(adapter.itemCount)
        val decorationCount = recyclerview.itemDecorationCount
        if (decorationCount > 0) {
            for (i in 0 until decorationCount) {
                recyclerview.removeItemDecorationAt(i)
            }
        }
        recyclerview.addItemDecoration(decoration)

    }


}