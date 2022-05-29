package com.ekremsenturk.themoviesdb.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ekremsenturk.core.MovieRepository
import com.ekremsenturk.themoviesdb.ui.detail.navigation.DetailDestination

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val movieId: String = checkNotNull(savedStateHandle[DetailDestination.movieIdArg])

    var detailUiState by mutableStateOf(DetailUiState())
        private set

}