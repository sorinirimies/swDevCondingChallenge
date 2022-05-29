package com.ekremsenturk.api.data

import com.google.gson.annotations.SerializedName

data class ApiCrewMember(
    val name: String,
    val job: String,
    @SerializedName("profile_path")
    val profilePath: String?
)