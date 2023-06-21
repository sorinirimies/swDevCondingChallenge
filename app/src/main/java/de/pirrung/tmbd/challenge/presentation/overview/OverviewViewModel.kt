package de.pirrung.tmbd.challenge.presentation.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.pirrung.tmbd.challenge.domain.use_case.GetMovieDetails
import de.pirrung.tmbd.challenge.domain.use_case.GetNowPlayingMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetPopularMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetTopRatedMovies
import de.pirrung.tmbd.challenge.domain.use_case.GetUpcomingMovies
import de.pirrung.tmbd.challenge.presentation.details.DetailsViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val getMovieDetails: GetMovieDetails,
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

    private val _detailState = MutableStateFlow<DetailsViewState>(DetailsViewState.Loading)
    val detailState = _detailState
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            DetailsViewState.Loading
        )

    private val _uiEventFlow = MutableSharedFlow<OverviewUiEvent>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

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
            viewModelScope.launch {
                _detailState.emit(DetailsViewState.Loading)
                _uiEventFlow.emit(OverviewUiEvent.ShowBottomSheet)
                getMovieDetails(event.movie.id)
                    .onSuccess {
                        _detailState.emit(
                            DetailsViewState.Available(
                                details = it
                            )
                        )
                    }
                    .onFailure {
                        _detailState.emit(DetailsViewState.Error)
                    }
            }
        }
    }

}