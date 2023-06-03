package de.pirrung.tmbd.challenge.domain.model.details

import java.util.UUID

data class Cast(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val character: String,
    val profileUrl: String
)
