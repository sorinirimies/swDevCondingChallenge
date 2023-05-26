package de.pirrung.tmbd.challenge.presentation.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.use_case.GetNowPlayingMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetPopularMovies
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OverviewViewModel(
    getPopularMovies: GetPopularMovies,
    getNowPlayingMovies: GetNowPlayingMovies
) : ViewModel() {

    private val _state = MutableStateFlow<OverviewViewState>(OverviewViewState.Loading)
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            OverviewViewState.Loading
        )

    private val _uiEventFlow = MutableSharedFlow<OverviewUiEvent>()
    val uiEventFlow = _uiEventFlow

    init {
        viewModelScope.launch {
            var popularMovies = emptyList<Movie>()
            getPopularMovies()
                .onSuccess {
                    popularMovies = it
                }
                .onFailure {
                    _uiEventFlow.emit(OverviewUiEvent.ShowSnackBar("Something went wrong. Check your connection"))
                }

            var nowPlayingMovies = emptyList<Movie>()
            getNowPlayingMovies()
                .onSuccess {
                    nowPlayingMovies = it
                }
                .onFailure {
                    _uiEventFlow.emit(OverviewUiEvent.ShowSnackBar("Something went wrong. Check your connection"))

                }

            _state.emit(
                OverviewViewState.Available(
                    popularMovies = popularMovies,
                    nowPlayingMovies = nowPlayingMovies
                )
            )
        }
    }

    fun onEvent(event: OverviewEvent) = when (event) {
        is OverviewEvent.OnMovieClick -> {

        }
    }

}