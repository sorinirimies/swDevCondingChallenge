package de.pirrung.tmbd.challenge.data.remote

import de.pirrung.tmbd.challenge.data.remote.dto.MovieDto
import de.pirrung.tmbd.challenge.data.remote.dto.MovieResponse
import de.pirrung.tmbd.challenge.data.remote.dto.details.MovieDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApi {
    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") appendToResponse: String
    ): MovieDetailsDto

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(): MovieResponse

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(): MovieResponse

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(): MovieResponse

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(): MovieResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    }
}