package com.ekremsenturk.themoviesdb.ui.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekremsenturk.core.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    var overviewUiState by mutableStateOf(
        OverviewUiState(
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            true
        )
    )
        private set

    fun onStart() {
        viewModelScope.launch(Dispatchers.IO) {
            val popularMoviesDeferred = async {
                try {
                    movieRepository.getPopularMovies()
                } catch (e: Exception) {
                    emptyList()
                }
            }
            val topRatedMoviesDeferred = async {
                try {
                    movieRepository.getTopRatedMovies()
                } catch (e: Exception) {
                    emptyList()
                }
            }
            val upcomingMoviesDeferred = async {
                try {
                    movieRepository.getUpcomingMovies()
                } catch (e: Exception) {
                    emptyList()
                }
            }
            val nowPlayingMoviesDeferred = async {
                try {
                    movieRepository.getNowPlayingMovies()
                } catch (e: Exception) {
                    emptyList()
                }
            }
            val popularMovies = popularMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val nowPlayingMovies = nowPlayingMoviesDeferred.await()
            overviewUiState = OverviewUiState(
                popularMovies,
                nowPlayingMovies,
                topRatedMovies,
                upcomingMovies,
                false
            )
        }
    }
}