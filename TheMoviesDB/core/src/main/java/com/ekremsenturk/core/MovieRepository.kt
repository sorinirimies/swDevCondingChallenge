package com.ekremsenturk.core

import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.core.model.MovieDetails

/**
 * A repository interface to fetch movie information from the backend.
 */
interface MovieRepository {

    suspend fun getMovieDetails(movieId: Int): MovieDetails

    suspend fun getNowPlayingMovies(): List<Movie>

    suspend fun getPopularMovies(): List<Movie>

    suspend fun getTopRatedMovies(): List<Movie>

    suspend fun getUpcomingMovies(): List<Movie>

}