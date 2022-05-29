package com.ekremsenturk.api.data

import com.google.gson.annotations.SerializedName

data class ApiMovie(
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String?,
    val title: String,
)