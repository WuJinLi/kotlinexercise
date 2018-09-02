package com.wjl.kotlinexercise

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

/**
 * @author: wjl
 * @date:2018/9/2
 */
class ListAdapter(val context: Context, val list: ArrayList<String>) : BaseAdapter() {

    var rightListener: RightListener? = null

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var viewHolder: ViewHolder? = null
        var view: View
        if (p1 == null) {
            view = View.inflate(context, R.layout.ly_item, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = p1
            viewHolder = view.tag as ViewHolder
        }

        var itemContent = list.get(p0)
        if (itemContent is String) {
            viewHolder.item.text = itemContent
        } else {
            viewHolder.item.text = ""
        }

        viewHolder.btn.setOnClickListener {
            rightListener!!.onClick(p0)
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }


    class ViewHolder(var view: View) {
        var item: TextView = view.findViewById(R.id.tv_item) as TextView
        var btn: Button = view.findViewById(R.id.btn_button) as Button
    }


    fun setRightClickListener(rightListener: RightListener) {
        this.rightListener = rightListener
    }
}