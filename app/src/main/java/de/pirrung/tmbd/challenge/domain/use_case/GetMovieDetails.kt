package de.pirrung.tmbd.challenge.domain.use_case

import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails
import de.pirrung.tmbd.challenge.domain.repository.TMDBRepository

class GetMovieDetails(
    private val repository: TMDBRepository
) {
    suspend operator fun invoke(
        movieId: Int
    ): Result<MovieDetails> {
        return repository.getMovieDetails(movieId)
    }

}