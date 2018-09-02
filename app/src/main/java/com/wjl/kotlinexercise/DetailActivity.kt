package com.wjl.kotlinexercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.ac_detail.*


/**
 * @author: wjl
 * @date:2018/9/2
 */
class DetailActivity : AppCompatActivity() {

    var detailInfo: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_detail)
        initData()
        tv_detail.text = detailInfo
    }

    private fun initData() {
        detailInfo = intent.getStringExtra("DETAILINFO")
    }
}