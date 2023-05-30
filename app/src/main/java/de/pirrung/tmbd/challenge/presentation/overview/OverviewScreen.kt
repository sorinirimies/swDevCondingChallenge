package de.pirrung.tmbd.challenge.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.presentation.overview.components.HorizontalMovieList
import de.pirrung.tmbd.challenge.presentation.overview.components.OverviewTopAppBar
import org.koin.androidx.compose.get

@Composable
fun MovieOverviewScreen(
    viewModel: OverviewViewModel = get()
) {
    OverviewContent(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
        state = viewModel.state.collectAsState().value
    )
}

@Composable
fun OverviewContent(
    modifier: Modifier = Modifier,
    state: OverviewViewState
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OverviewTopAppBar()
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
                    upcomingMovies = state.upcomingMovies
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

@Composable
private fun AvailableContent(
    modifier: Modifier = Modifier,
    popularMovies: List<Movie>,
    nowPlayingMovies: List<Movie>,
    topRatedMovies: List<Movie>,
    upcomingMovies: List<Movie>
) {
    Column(
        modifier = modifier
    ) {
        PopularMovies(
            modifier = Modifier.fillMaxWidth(),
            popularMovies = popularMovies
        )
    }
}

@Composable
private fun PopularMovies(
    modifier: Modifier,
    popularMovies: List<Movie>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Popular",
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalMovieList(
            movies = popularMovies
        )
    }
}