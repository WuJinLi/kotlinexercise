package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Url(
        @SerializedName("name") val name: String? = "",
        @SerializedName("url") val url: String? = "",
        @SerializedName("size") val size: Long? = 0
) : Serializable