package com.ekremsenturk.api

import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.api.data.ApiMovieDetails

/**
 * Provides access to the TMDB backend.
 */
interface ApiClient {

    /**
     * Retrieves details for the movie with the specified [movieId].
     */
    suspend fun getDetails(movieId: Int): ApiMovieDetails

    suspend fun getNowPlayingMovies(): List<ApiMovie>

    suspend fun getPopularMovies(): List<ApiMovie>

    suspend fun getTopRatedMovies(): List<ApiMovie>

    suspend fun getUpcomingMovies(): List<ApiMovie>
}