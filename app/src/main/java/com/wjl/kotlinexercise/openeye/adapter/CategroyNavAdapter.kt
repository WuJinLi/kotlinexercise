package com.wjl.kotlinexercise.openeye.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.openeye.model.CategroyModel

/**
 * @author: wujinli
 * @date:2018/10/16
 * @desc:
 */
class CategroyNavAdapter(context: Context) : RecyclerView.Adapter<CategroyNavAdapter.CategroyViewHolder>() {

    var mContext: Context? = null
    var mCategroyList: MutableList<CategroyModel.ItemListBean> = ArrayList()

    val itemHeader:Int=0x1
    val itemHeaderLine:Int=0x2

    init {
        mContext = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategroyViewHolder {
        val itemview = LayoutInflater.from(mContext).inflate(R.layout.ly_categroy, p0,false)
        return CategroyViewHolder(itemview)
    }

    override fun getItemCount() = mCategroyList.size

    override fun onBindViewHolder(p0: CategroyViewHolder, p1: Int) {
        var itemlistbean = mCategroyList[p1]


        Glide.with(mContext!!).load(itemlistbean.data!!.icon).into(p0.img_category_icon)
        p0.tv_category_name.text = itemlistbean.data!!.title
        p0.tv_category_des.text = itemlistbean.data!!.description
    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    class CategroyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
//        val img_category_icon = itemview.findViewById(R.id.img_category_icon) as ImageView
//        val tv_category_name = itemview.findViewById(R.id.tv_category_name) as TextView
//        val tv_category_des = itemview.findViewById(R.id.tv_category_des) as TextView

        val img_category_icon = itemview.findViewById<ImageView>(R.id.img_category_icon)
        val tv_category_name = itemview.findViewById<TextView>(R.id.tv_category_name)
        val tv_category_des = itemview.findViewById<TextView>(R.id.tv_category_des)
    }


    fun setCategroyList(categroyList: List<CategroyModel.ItemListBean>) {
        if (mCategroyList != null) {
            mCategroyList!!.clear()
        }

        mCategroyList = categroyList as MutableList<CategroyModel.ItemListBean>
        notifyDataSetChanged()
    }
}