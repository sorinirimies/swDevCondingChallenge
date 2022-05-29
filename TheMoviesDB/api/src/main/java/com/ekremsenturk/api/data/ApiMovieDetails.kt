package com.ekremsenturk.api.data

import com.google.gson.annotations.SerializedName

data class ApiMovieDetails(
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String?,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genres")
    val genres: List<ApiGenre>,
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("vote_average")
    val voteAverage: Float,
    val credits: ApiCredits
)