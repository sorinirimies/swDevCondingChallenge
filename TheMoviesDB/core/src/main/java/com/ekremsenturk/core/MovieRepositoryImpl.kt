package com.ekremsenturk.core

import com.ekremsenturk.api.ApiClient
import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.core.model.MovieDetails
import com.ekremsenturk.core.model.toDomainMovie
import com.ekremsenturk.core.model.toDomainMovieDetails

/**
 * An implementation of [MovieRepository] using a REST API.
 */
internal class MovieRepositoryImpl(
    private val apiClient: ApiClient
) : MovieRepository {

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return apiClient.getDetails(movieId).toDomainMovieDetails()
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiClient.getNowPlayingMovies())
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiClient.getPopularMovies())
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiClient.getTopRatedMovies())
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiClient.getUpcomingMovies())
    }

    private fun mapApiMoviesToDomainMovies(apiMovies: List<ApiMovie>): List<Movie> {
        return apiMovies.map { it.toDomainMovie() }
    }
}