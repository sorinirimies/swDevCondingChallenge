package com.ekremsenturk.api

import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.api.data.ApiMovieDetails

/**
 * Provides access to the TMDB backend.
 */
interface ApiClient {

    /**
     * Get the primary information about the movie with the specified [movieId].
     */
    suspend fun getDetails(movieId: Int): ApiMovieDetails

    /**
     * Get a list of movies in theatres.
     */
    suspend fun getNowPlayingMovies(): List<ApiMovie>

    /**
     * Get a list of the current popular movies on TMDB.
     */
    suspend fun getPopularMovies(): List<ApiMovie>

    /**
     * Get the top rated movies on TMDB.
     */
    suspend fun getTopRatedMovies(): List<ApiMovie>

    /**
     * Get a list of upcoming movies in theatres.
     */
    suspend fun getUpcomingMovies(): List<ApiMovie>
}