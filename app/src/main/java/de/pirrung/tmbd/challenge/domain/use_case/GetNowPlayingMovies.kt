package de.pirrung.tmbd.challenge.domain.use_case

import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.repository.TMDBRepository
import kotlinx.coroutines.flow.Flow

class GetNowPlayingMovies(
    private val repository: TMDBRepository
) {

    suspend operator fun invoke(): Flow<List<Movie>> {
        return repository.getNowPlayingMovies()
    }
}