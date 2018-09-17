package com.wjl.kotlinexercise.refresh

import java.util.*

/**
 * author: WuJinLi
 * time  : 2018/9/17
 * desc  :
 */
data class GankBeanList(val results: List<GankBean>)

data class GankBean(val desc: String, val images: List<String>, val publishedAt: Date, val url: String)