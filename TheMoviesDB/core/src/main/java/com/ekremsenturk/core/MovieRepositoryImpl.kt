package com.ekremsenturk.core

import com.ekremsenturk.api.ApiService
import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.core.model.toDomainMovie

/**
 * An implementation of [MovieRepository] using a REST API.
 */
internal class MovieRepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return apiService.getNowPlayingMovies(API_KEY).results.map { it.toDomainMovie() }
    }

    companion object {
        /**
         * This key is required to access the TMDB API.
         */
        private const val API_KEY = "37023a75e7f3882153de60dd787b59de"
    }

}