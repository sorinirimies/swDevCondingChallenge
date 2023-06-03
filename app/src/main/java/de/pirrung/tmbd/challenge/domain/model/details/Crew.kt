package de.pirrung.tmbd.challenge.domain.model.details

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class Crew(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val job: String,
    val profileUrl: String
)
