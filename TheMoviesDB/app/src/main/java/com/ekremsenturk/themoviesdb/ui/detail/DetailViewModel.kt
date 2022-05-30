package com.ekremsenturk.themoviesdb.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekremsenturk.core.MovieRepository
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    var detailUiState by mutableStateOf(DetailUiState(
        loading = true,
        title = "",
        backdrop = null,
        poster = null,
        overview = "",
        genres = "",
        voteCount = 0,
        voteAverage = 0.0f,
        cast = emptyList(),
        crew = emptyList()
    ))
        private set

    fun onStart(movieId: Int) {
        viewModelScope.launch {
            val movieDetails = movieRepository.getMovieDetails(movieId)
            detailUiState = DetailUiState(
                loading = false,
                title = movieDetails.title,
                backdrop = movieDetails.backdrop,
                poster = movieDetails.poster,
                overview = movieDetails.overview,
                genres = movieDetails.genres.joinToString(", "),
                voteCount = movieDetails.voteCount,
                voteAverage = movieDetails.voteAverage,
                cast = movieDetails.cast,
                crew = movieDetails.crew
            )
        }
    }

}