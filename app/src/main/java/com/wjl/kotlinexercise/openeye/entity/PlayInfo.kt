package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlayInfo(
        @SerializedName("height") val height: Int? = 0,
        @SerializedName("width") val width: Int? = 0,
        @SerializedName("urlList") val urlList: List<Url?>? = listOf(),
        @SerializedName("name") val name: String? = "",
        @SerializedName("type") val type: String? = "",
        @SerializedName("url") val url: String? = ""
) : Serializable