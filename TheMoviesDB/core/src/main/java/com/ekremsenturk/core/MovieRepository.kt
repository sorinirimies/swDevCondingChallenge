package com.ekremsenturk.core

import com.ekremsenturk.core.model.Movie

/**
 * A repository interface to fetch movie information from the backend.
 */
interface MovieRepository {

    suspend fun getNowPlayingMovies(): List<Movie>

}