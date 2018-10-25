package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(
        @SerializedName("type") val type: String? = "",
        @SerializedName("data") var data: Data? = Data(),
        @SerializedName("id") val id: Int? = 0,
        @SerializedName("adIndex") val adIndex: Int? = 0,
        @SerializedName("dataType") var dataType: String = ""
) : Serializable