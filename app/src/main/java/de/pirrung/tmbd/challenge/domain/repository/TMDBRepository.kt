package de.pirrung.tmbd.challenge.domain.repository

import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.model.MovieDetails

interface TMDBRepository {
    suspend fun getPopularMovies(): Result<List<Movie>>
    suspend fun getNowPlayingMovies(): Result<List<Movie>>
    suspend fun getTopRatedMovies(): Result<List<Movie>>
    suspend fun getUpcomingMovies(): Result<List<Movie>>
    suspend fun getMovieDetails(movieId: Int): Result<MovieDetails>
}