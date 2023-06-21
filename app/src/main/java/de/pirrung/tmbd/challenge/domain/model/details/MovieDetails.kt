package de.pirrung.tmbd.challenge.domain.model.details

data class MovieDetails(
    val title: String,
    val genres: List<Genre>,
    val overview: String,
    val credits: Credits,
    val recommendations: Recommendations,
    val posterUrl: String,
    val backdropPosterUrl: String,
    val rating: Double,
    val voteAverage: Double,
    val voteCount: Int
)