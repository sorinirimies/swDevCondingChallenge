package de.pirrung.tmbd.challenge.data.repository

import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.data.remote.dto.details.toMovieDetails
import de.pirrung.tmbd.challenge.data.remote.dto.toMovie
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.model.MovieDetails
import de.pirrung.tmbd.challenge.domain.repository.TMDBRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TMDBRepositoryImpl(
    private val api: TMDBApi
) : TMDBRepository {
    override suspend fun getPopularMovies(): Flow<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            flowOf(movieDto.results.map { it.toMovie() })
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(emptyList())
        }
    }

    override suspend fun getNowPlayingMovies(): Flow<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            flowOf(movieDto.results.map { it.toMovie() })
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(emptyList())
        }
    }

    override suspend fun getTopRatedMovies(): Flow<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            flowOf(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(emptyList())
        }
    }

    override suspend fun getUpcomingMovies(): Flow<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            flowOf(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf(emptyList())
        }
    }

    override suspend fun getMovieDetails(
        movieId: Int
    ): Flow<MovieDetails> {
        return try {
            val movieDto = api.getMovieDetails(
                movieId = movieId
            )
            flowOf(
                movieDto.toMovieDetails()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            flowOf()
        }
    }

}