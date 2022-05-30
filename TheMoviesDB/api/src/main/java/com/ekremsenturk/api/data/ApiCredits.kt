package com.ekremsenturk.api.data

data class ApiCredits(
    val cast: List<ApiCastMember>,
    val crew: List<ApiCrewMember>
)