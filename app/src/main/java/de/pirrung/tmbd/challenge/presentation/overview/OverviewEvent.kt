package de.pirrung.tmbd.challenge.presentation.overview

import de.pirrung.tmbd.challenge.domain.model.Movie

sealed interface OverviewEvent {
    data class OnMovieClick(val movie: Movie) : OverviewEvent
}
