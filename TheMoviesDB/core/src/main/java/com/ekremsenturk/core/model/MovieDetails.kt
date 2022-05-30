package com.ekremsenturk.core.model

data class MovieDetails(
    val id: Int,
    val poster: String?,
    val overview: String,
    val releaseDate: String,
    val genres: List<String>,
    val title: String,
    val backdrop: String?,
    val voteCount: Int,
    val voteAverage: Float,
    val cast: List<CastMember>,
    val crew: List<CrewMember>,
    val similarMovies: List<Movie>,
    val recommendations: List<Movie>
)