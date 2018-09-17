package com.wjl.kotlinexercise.refresh.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wjl.kotlinexercise.R
import com.wjl.kotlinexercise.refresh.GankBean

/**
 * author: WuJinLi
 * time  : 2018/9/17
 * desc  :界面显示数据的adapter
 */
class DetailsAdapter(context: Context) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    private var mContext: Context? = null
    private var list = mutableListOf<GankBean>()

    init {
        mContext = context
    }

    fun setData(list: MutableList<GankBean>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_details_news, parent, false)
        return DetailsViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.gank_item_title.text=list[position].desc
        holder.gank_item_subtitle.text=list[position].desc
        Glide.with(mContext!!).load(list[position].images).into(holder.gank_item_image)
    }


    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gank_item_title: TextView = itemView.findViewById(R.id.gank_item_title)
        var gank_item_subtitle: TextView = itemView.findViewById(R.id.gank_item_subtitle)
        var gank_item_image: ImageView = itemView.findViewById(R.id.gank_item_image)
    }
}