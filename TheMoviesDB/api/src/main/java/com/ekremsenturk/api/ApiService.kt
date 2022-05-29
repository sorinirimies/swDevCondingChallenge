package com.ekremsenturk.api

import com.ekremsenturk.api.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Provides access to the TMDB backend.
 */
interface ApiService {
    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String): MovieResponse
}