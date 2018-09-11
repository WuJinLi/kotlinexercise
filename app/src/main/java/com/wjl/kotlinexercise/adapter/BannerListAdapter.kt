package com.wjl.kotlinexercise.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.mvp.model.Banner

/**
 * @author: wjl
 * @date:2018/9/2
 */
class BannerListAdapter(val context: Context) : BaseAdapter() {

    var itemList: List<Banner> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    fun addData(itemList: List<Banner>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewHolder: ViewHolder? = null
        var view: View
        if (p1 == null) {
            view = View.inflate(context, R.layout.item_banner, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = p1
            viewHolder = view.tag as ViewHolder
        }
        Glide.with(context).load(itemList.get(p0).imagePath).into(viewHolder.iv_background)
        viewHolder.tv_desc.text = itemList.get(p0).title
        return view
    }

    override fun getItem(p0: Int): Any {
        return itemList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return itemList.size
    }


    class ViewHolder(var view: View) {
        var iv_background: ImageView = view.findViewById(R.id.iv_background) as ImageView
        var tv_desc: TextView = view.findViewById(R.id.tv_desc) as TextView
    }
}