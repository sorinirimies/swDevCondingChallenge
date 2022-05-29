package com.ekremsenturk.themoviesdb.ui.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ekremsenturk.core.MovieRepository

class OverviewViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    var overviewUiState by mutableStateOf(OverviewUiState())
        private set

}