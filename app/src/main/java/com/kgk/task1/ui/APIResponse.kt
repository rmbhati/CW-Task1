package com.kgk.task1.ui

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("albumId") val albumId: String,
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String,
)

