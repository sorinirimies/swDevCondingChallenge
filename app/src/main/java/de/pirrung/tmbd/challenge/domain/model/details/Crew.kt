package de.pirrung.tmbd.challenge.domain.model.details

import com.google.gson.annotations.SerializedName

data class Crew(
    val name: String,
    val job: String,
    val profileUrl: String
)
