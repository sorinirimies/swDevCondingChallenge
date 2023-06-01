package de.pirrung.tmbd.challenge.presentation.details

import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails

sealed class DetailsViewState {
    object Loading : DetailsViewState()
    data class Available(
        val details: MovieDetails
    ) : DetailsViewState()

    object Error : DetailsViewState()
}