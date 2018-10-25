package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Provider(
        @SerializedName("name") val name: String? = "",
        @SerializedName("alias") val alias: String? = "",
        @SerializedName("icon") val icon: String? = ""
) : Serializable