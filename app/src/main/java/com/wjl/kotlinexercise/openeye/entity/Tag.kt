package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tag(
        @SerializedName("id") val id: Int? = 0,
        @SerializedName("name") val name: String? = "",
        @SerializedName("actionUrl") val actionUrl: String? = "",
        @SerializedName("desc") val desc: String? = "",
        @SerializedName("bgPicture") val bgPicture: String? = "",
        @SerializedName("headerImage") val headerImage: String? = "",
        @SerializedName("tagRecType") val tagRecType: String? = ""
) : Serializable