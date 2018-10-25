package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Shield(
        @SerializedName("itemType") val itemType: String? = "",
        @SerializedName("itemId") val itemId: Int? = 0,
        @SerializedName("shielded") val shielded: Boolean? = false
) : Serializable