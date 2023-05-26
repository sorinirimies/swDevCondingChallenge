package de.pirrung.tmbd.challenge.presentation.overview

import de.pirrung.tmbd.challenge.domain.model.Movie

sealed class OverviewViewState {
    object Loading : OverviewViewState()
    data class Available(
        val popularMovies: List<Movie> = emptyList(),
        val nowPlayingMovies: List<Movie> = emptyList(),
        val topRatedMovies: List<Movie> = emptyList(),
        val upcomingMovies: List<Movie> = emptyList(),
    ) : OverviewViewState()
}
