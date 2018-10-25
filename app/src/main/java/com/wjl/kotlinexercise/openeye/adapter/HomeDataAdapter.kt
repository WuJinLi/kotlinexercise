package com.wjl.kotlinexercise.openeye.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.openeye.entity.Item
import com.wjl.kotlinexercise.openeye.holder.HorizontalScrollCard
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity

/**
 * @author: wujinli
 * @date:2018/10/25
 * @desc: 首页adapter
 */
class HomeDataAdapter(context: Context, data: List<HomeDataEntity>) : BaseMultiItemQuickAdapter<HomeDataEntity, BaseViewHolder>(data) {



    init {
        addItemType(HomeDataEntity.TYPE_horizontalScrollCard, R.layout.item_home_horizontalscrollcard)
    }


    override fun convert(helper: BaseViewHolder, entity: HomeDataEntity) {
        val item: Item = entity!!.getItem()!!

        when (entity.itemType) {
            HomeDataEntity.TYPE_horizontalScrollCard -> {
                HorizontalScrollCard(super.mContext, helper, entity)
            }
        }
    }
}