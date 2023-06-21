package de.pirrung.tmbd.challenge.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<MovieDto>
)