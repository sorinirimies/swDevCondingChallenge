package de.pirrung.tmbd.challenge.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val backdropPosterUrl: String = "",
)
