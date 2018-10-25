package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Content(
        @SerializedName("type") val type: String? = "",
        @SerializedName("data") val data: DataX? = DataX(),
        @SerializedName("tag") val tag: List<Tag?>? = listOf(),
        @SerializedName("id") val id: Int? = 0,
        @SerializedName("adIndex") val adIndex: Int? = 0
) : Serializable