package com.ekremsenturk.api

import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.api.data.ApiMovieDetails
import com.ekremsenturk.api.service.ApiService

internal class ApiClientImpl(
    private val apiService: ApiService
) : ApiClient {

    override suspend fun getDetails(movieId: Int): ApiMovieDetails {
        return apiService.getDetails(movieId, "credits,similar,recommendations")
    }

    override suspend fun getNowPlayingMovies(): List<ApiMovie> {
        return apiService.getNowPlayingMovies().results
    }

    override suspend fun getPopularMovies(): List<ApiMovie> {
        return apiService.getPopularMovies().results
    }

    override suspend fun getTopRatedMovies(): List<ApiMovie> {
        return apiService.getTopRatedMovies().results
    }

    override suspend fun getUpcomingMovies(): List<ApiMovie> {
        return apiService.getUpcomingMovies().results
    }
}