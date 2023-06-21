package de.pirrung.tmbd.challenge.domain.model.details

import de.pirrung.tmbd.challenge.domain.model.Movie

data class Recommendations(
    val movies: List<Movie>
)