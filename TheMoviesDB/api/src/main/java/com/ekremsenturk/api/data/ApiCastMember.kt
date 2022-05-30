package com.ekremsenturk.api.data

import com.google.gson.annotations.SerializedName

data class ApiCastMember(
    val name: String,
    val character: String,
    @SerializedName("profile_path")
    val profilePath: String?
)