package de.pirrung.tmbd.challenge.presentation.overview

sealed interface OverviewUiEvent {
    data class ShowSnackBar(val message: String) : OverviewUiEvent
}