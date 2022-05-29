package com.ekremsenturk.core

import com.ekremsenturk.api.ApiService
import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.core.model.MovieDetails
import com.ekremsenturk.core.model.toDomainMovie
import com.ekremsenturk.core.model.toDomainMovieDetails

/**
 * An implementation of [MovieRepository] using a REST API.
 */
internal class MovieRepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return apiService.getDetails(movieId, "credits").toDomainMovieDetails()
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiService.getNowPlayingMovies().results)
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiService.getPopularMovies().results)
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiService.getTopRatedMovies().results)
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return mapApiMoviesToDomainMovies(apiService.getUpcomingMovies().results)
    }

    private fun mapApiMoviesToDomainMovies(apiMovies: List<ApiMovie>): List<Movie> {
        return apiMovies.map { it.toDomainMovie() }
    }

}