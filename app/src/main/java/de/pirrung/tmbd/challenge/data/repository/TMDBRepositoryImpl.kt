package de.pirrung.tmbd.challenge.data.repository

import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.data.remote.dto.details.toMovieDetails
import de.pirrung.tmbd.challenge.data.remote.dto.toMovie
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.model.MovieDetails
import de.pirrung.tmbd.challenge.domain.repository.TMDBRepository

class TMDBRepositoryImpl(
    private val api: TMDBApi
) : TMDBRepository {
    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            Result.success(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getNowPlayingMovies(): Result<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            Result.success(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getTopRatedMovies(): Result<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            Result.success(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val movieDto = api.getPopularMovies()
            Result.success(
                movieDto.results.map { it.toMovie() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getMovieDetails(
        movieId: Int
    ): Result<MovieDetails> {
        return try {
            val movieDto = api.getMovieDetails(
                movieId = movieId
            )
            Result.success(
                movieDto.toMovieDetails()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

}