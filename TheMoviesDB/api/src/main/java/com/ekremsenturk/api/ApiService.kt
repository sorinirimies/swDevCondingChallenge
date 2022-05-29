package com.ekremsenturk.api

import com.ekremsenturk.api.data.ApiMovieDetails
import com.ekremsenturk.api.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Provides access to the TMDB backend.
 */
interface ApiService {

    @GET("/3/movie/{movie_id}")
    suspend fun getDetails(@Path("movie_id") movieId: Int, @Query("append_to_response") appendToResponse: String): ApiMovieDetails

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(): MovieResponse

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(): MovieResponse

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(): MovieResponse

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(): MovieResponse
}