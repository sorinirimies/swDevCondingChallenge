package de.pirrung.tmbd.challenge.presentation.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.use_case.GetNowPlayingMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetPopularMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetTopRatedMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetUpcomingMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OverviewViewModel(
    getPopularMovies: GetPopularMovies,
    getNowPlayingMovies: GetNowPlayingMovies,
    getTopRatedMovies: GetTopRatedMovies,
    getUpcomingMovies: GetUpcomingMovies
) : ViewModel() {

    private val _state = MutableStateFlow<OverviewViewState>(OverviewViewState.Loading)
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            OverviewViewState.Loading
        )

    init {
        viewModelScope.launch {
            combine(
                getNowPlayingMovies(),
                getPopularMovies(),
                getTopRatedMovies(),
                getUpcomingMovies()
            ) { nowPlayingMovies,
                popularMovies,
                topRatedMovies,
                upcomingMovies ->
                OverviewViewState.Available(
                    popularMovies = popularMovies,
                    nowPlayingMovies = nowPlayingMovies,
                    topRatedMovies = topRatedMovies,
                    upcomingMovies = upcomingMovies
                )
            }.collectLatest {
                _state.emit(it)
            }
        }
    }

    fun onEvent(event: OverviewEvent) = when (event) {
        is OverviewEvent.OnMovieClick -> {

        }
    }

}