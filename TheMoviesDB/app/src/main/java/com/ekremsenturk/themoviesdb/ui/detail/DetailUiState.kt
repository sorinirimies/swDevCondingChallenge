package com.ekremsenturk.themoviesdb.ui.detail

import com.ekremsenturk.core.model.CastMember
import com.ekremsenturk.core.model.CrewMember

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
    val crew: List<CrewMember>
)