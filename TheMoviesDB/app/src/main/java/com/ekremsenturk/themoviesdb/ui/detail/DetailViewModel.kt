package com.ekremsenturk.themoviesdb.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ekremsenturk.core.MovieRepository

class DetailViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    var detailUiState by mutableStateOf(DetailUiState())
        private set

}