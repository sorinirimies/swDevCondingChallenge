package com.ekremsenturk.core

import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.core.model.MovieDetails

/**
 * A repository interface to fetch movie information from the backend.
 */
interface MovieRepository {

    /**
     * Get the primary information about the movie with the specified [movieId].
     */
    suspend fun getMovieDetails(movieId: Int): MovieDetails

    /**
     * Get a list of movies in theatres.
     */
    suspend fun getNowPlayingMovies(): List<Movie>

    /**
     * Get a list of the current popular movies on TMDB.
     */
    suspend fun getPopularMovies(): List<Movie>

    /**
     * Get the top rated movies on TMDB.
     */
    suspend fun getTopRatedMovies(): List<Movie>

    /**
     * Get a list of upcoming movies in theatres.
     */
    suspend fun getUpcomingMovies(): List<Movie>

}