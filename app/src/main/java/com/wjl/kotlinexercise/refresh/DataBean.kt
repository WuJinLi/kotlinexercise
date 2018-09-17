package com.wjl.kotlinexercise.refresh


/**
 * author: WuJinLi
 * time  : 2018/9/17
 * desc  :
 */
data class GankBeanList(val error: Boolean, val results: List<GankBean>)

data class GankBean(val _id: String, val createdAt: String, val desc: String, val images: List<String>, val publishedAt: String, val source: String, val type: String, val url: String, val used: Boolean, val who: String)