package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Consumption(
        @SerializedName("collectionCount") val collectionCount: Int? = 0,
        @SerializedName("shareCount") val shareCount: Int? = 0,
        @SerializedName("replyCount") val replyCount: Int? = 0
) : Serializable