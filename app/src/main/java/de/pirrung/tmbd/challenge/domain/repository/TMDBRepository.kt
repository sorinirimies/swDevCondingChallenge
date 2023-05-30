package de.pirrung.tmbd.challenge.domain.repository

import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface TMDBRepository {
    suspend fun getPopularMovies(): Flow<List<Movie>>
    suspend fun getNowPlayingMovies(): Flow<List<Movie>>
    suspend fun getTopRatedMovies(): Flow<List<Movie>>
    suspend fun getUpcomingMovies(): Flow<List<Movie>>
    suspend fun getMovieDetails(movieId: Int): Flow<MovieDetails>
}