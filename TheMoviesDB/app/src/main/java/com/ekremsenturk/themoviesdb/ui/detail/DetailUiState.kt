package com.ekremsenturk.themoviesdb.ui.detail

import com.ekremsenturk.core.model.CastMember
import com.ekremsenturk.core.model.CrewMember
import com.ekremsenturk.core.model.Movie

data class DetailUiState(
    val loading: Boolean,
    val title: String,
    val backdrop: String?,
    val poster: String?,
    val overview: String,
    val genres: String,
    val voteCount: Int,
    val voteAverage: Float,
    val cast: List<CastMember>,
    val crew: List<CrewMember>,
    val recommendations: List<Movie>,
    val similarMovies: List<Movie>
)