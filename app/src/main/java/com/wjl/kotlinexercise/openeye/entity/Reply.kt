package com.wjl.kotlinexercise.openeye.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Reply(
        @SerializedName("id") val id: Long? = 0,
        @SerializedName("videoId") val videoId: Int? = 0,
        @SerializedName("videoTitle") val videoTitle: String? = "",
        @SerializedName("message") val message: String? = "",
        @SerializedName("likeCount") val likeCount: Int? = 0,
        @SerializedName("showConversationButton") val showConversationButton: Boolean? = false,
        @SerializedName("parentReplyId") val parentReplyId: String? = "",
        @SerializedName("rootReplyId") val rootReplyId: String? = "",
        @SerializedName("ifHotReply") val ifHotReply: Boolean? = false,
        @SerializedName("liked") val liked: Boolean? = false,
        @SerializedName("user") val user: User? = User()
) : Serializable