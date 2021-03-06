package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cover(
        @SerializedName("feed") val feed: String? = "",
        @SerializedName("detail") val detail: String? = "",
        @SerializedName("blurred") val blurred: String? = "",
        @SerializedName("sharing") val sharing: String? = "",
        @SerializedName("homepage") val homepage: String? = ""
) : Serializable