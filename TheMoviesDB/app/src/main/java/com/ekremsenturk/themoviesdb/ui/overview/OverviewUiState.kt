package com.ekremsenturk.themoviesdb.ui.overview

import com.ekremsenturk.core.model.Movie

data class OverviewUiState(
    val popularMovies: List<Movie>,
    val nowPlayingMovies: List<Movie>,
    val topRatedMovies: List<Movie>,
    val upcomingMovies: List<Movie>,
    val loading: Boolean
)