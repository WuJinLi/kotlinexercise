package com.wjl.kotlinexercise

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wjl.kotlinexercise.ui.MainPageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initview()

    }

    private fun initview() {
        var adapter=ListAdapter(this,list)
        lv_listview.adapter=adapter

        lv_listview.setOnItemClickListener { adapterView, view, i, l ->

            intent= Intent(MainActivity@this,DetailActivity::class.java)
            intent.putExtra("DETAILINFO",adapter?.getItem(i)?.toString())
            startActivity(intent)
        }

        adapter.setRightClickListener(object:RightListener{
            override fun onClick(position: Int) {
                Toast.makeText(this@MainActivity,"this is $position",Toast.LENGTH_SHORT).show()

            }
        })
    }



    fun initData() {
        var i: Int = 0
        do {
            list.add("这是第 $i 条数据")
            i++
        } while (i < 20)
    }

}
