package de.pirrung.tmbd.challenge.presentation.overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.presentation.details.DetailsViewState
import de.pirrung.tmbd.challenge.presentation.details.MovieDetailsScreen
import de.pirrung.tmbd.challenge.presentation.overview.components.HorizontalMovieList
import de.pirrung.tmbd.challenge.presentation.overview.components.MovieItemLarge
import de.pirrung.tmbd.challenge.presentation.overview.components.MovieItemSmall
import kotlinx.coroutines.flow.SharedFlow
import org.koin.androidx.compose.getViewModel

@Composable
fun MovieOverviewScreen(
    modifier: Modifier = Modifier,
    viewModel: OverviewViewModel = getViewModel()
) {
    OverviewContent(
        modifier = modifier,
        state = viewModel.state.collectAsState().value,
        detailState = viewModel.detailState.collectAsState().value,
        uiEventFlow = viewModel.uiEventFlow,
        onMovieClick = {
            viewModel.onEvent(OverviewEvent.OnMovieClick(it))
        }
    )
}

@Composable
fun OverviewContent(
    modifier: Modifier = Modifier,
    state: OverviewViewState,
    detailState: DetailsViewState,
    uiEventFlow: SharedFlow<OverviewUiEvent>,
    onMovieClick: (movie: Movie) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state) {
            is OverviewViewState.Loading -> {
                LoadingContent()
            }

            is OverviewViewState.Available -> {
                AvailableContent(
                    modifier = Modifier.fillMaxSize(),
                    popularMovies = state.popularMovies,
                    nowPlayingMovies = state.nowPlayingMovies,
                    topRatedMovies = state.topRatedMovies,
                    upcomingMovies = state.upcomingMovies,
                    onMovieClick = onMovieClick
                )
                MovieDetailsSheet(
                    state = detailState,
                    uiEventFlow = uiEventFlow
                )
            }
        }
    }
}

@Composable
private fun LoadingContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator()
    }
}

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
private fun AvailableContent(
    modifier: Modifier = Modifier,
    popularMovies: List<Movie>,
    nowPlayingMovies: List<Movie>,
    topRatedMovies: List<Movie>,
    upcomingMovies: List<Movie>,
    onMovieClick: (movie: Movie) -> Unit
) {
    val scrollState = rememberScrollState()
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        Column(
            modifier = modifier
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MoviesSmall(
                modifier = Modifier.fillMaxWidth(),
                header = stringResource(id = R.string.overview_now_playing_movies_header),
                movies = nowPlayingMovies,
                onMovieClick = onMovieClick
            )
            MoviesSmall(
                modifier = Modifier.fillMaxWidth(),
                header = stringResource(id = R.string.overview_popular_movies_header),
                movies = popularMovies,
                onMovieClick = onMovieClick
            )
            MoviesLarge(
                modifier = Modifier.fillMaxWidth(),
                header = stringResource(id = R.string.overview_upcoming_movies_header),
                movies = upcomingMovies,
                onMovieClick = onMovieClick
            )
            MoviesSmall(
                modifier = Modifier.fillMaxWidth(),
                header = stringResource(id = R.string.overview_top_rated_movies_header),
                movies = topRatedMovies,
                onMovieClick = onMovieClick
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun MovieDetailsSheet(
    modifier: Modifier = Modifier,
    state: DetailsViewState,
    uiEventFlow: SharedFlow<OverviewUiEvent>
) {
    val showBottomSheet = rememberSaveable {
        mutableStateOf(false)
    }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    LaunchedEffect(key1 = Unit) {
        uiEventFlow.collect {
            when (it) {
                is OverviewUiEvent.ShowBottomSheet -> {
                    showBottomSheet.value = true
                }
            }
        }
    }

    if (showBottomSheet.value) {
        ModalBottomSheet(
            modifier = modifier
                .nestedScroll(rememberNestedScrollInteropConnection()),
            sheetState = bottomSheetState,
            onDismissRequest = {
                showBottomSheet.value = false
            },
            dragHandle = { Unit }
        ) {
            CompositionLocalProvider(
                LocalOverscrollConfiguration provides null
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    MovieDetailsScreen(
                        modifier = Modifier.fillMaxSize(),
                        state = state
                    )
                }
            }
        }
    }
}

@Composable
private fun MoviesSmall(
    modifier: Modifier = Modifier,
    header: String,
    movies: List<Movie>,
    onMovieClick: (movie: Movie) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = header,
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalMovieList(
            movies = movies,
            movieContent = {
                MovieItemSmall(
                    movie = it,
                    onMovieClick = onMovieClick
                )
            }
        )
    }
}

@Composable
private fun MoviesLarge(
    modifier: Modifier = Modifier,
    header: String,
    movies: List<Movie>,
    onMovieClick: (movie: Movie) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = header,
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalMovieList(
            movies = movies,
            movieContent = {
                MovieItemLarge(
                    movie = it,
                    onMovieClick = onMovieClick
                )
            }
        )
    }
}