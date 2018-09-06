package com.wjl.kotlinexercise.model

import com.squareup.moshi.Json

/**
 * @author: wjl
 * @date:2018/9/7
 */

data class HttpResult<T>(val data: T, val errorCode: Int, val errorMsg: String)

data class Banner(val desc: String, val id: Int, val imagePath: String, val isVisible: Int, val order: Int, val title: String, val type: Int, val url: String)