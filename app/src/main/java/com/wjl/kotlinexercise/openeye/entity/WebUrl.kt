package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WebUrl(
        @SerializedName("raw") val raw: String? = "",
        @SerializedName("forWeibo") val forWeibo: String? = ""
) : Serializable