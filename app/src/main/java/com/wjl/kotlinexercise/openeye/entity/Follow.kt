package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Follow(
        @SerializedName("itemType") val itemType: String? = "",
        @SerializedName("itemId") val itemId: Int? = 0,
        @SerializedName("followed") val followed: Boolean? = false
) : Serializable