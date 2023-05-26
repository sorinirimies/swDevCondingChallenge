package de.pirrung.tmbd.challenge.presentation.overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.domain.use_case.GetPopularMovies
import org.koin.androidx.compose.get

@Composable
fun MovieOverviewScreen(
    viewModel: OverviewViewModel = get()
) {
    OverviewContent(
        modifier = Modifier
            .fillMaxSize(),
        state = viewModel.state.collectAsState().value
    )
}

@Composable
fun OverviewContent(
    modifier: Modifier = Modifier,
    state: OverviewViewState
) {
    Column(
        modifier = modifier
    ) {
        when (state) {
            is OverviewViewState.Loading -> {
                LoadingContent()
            }

            is OverviewViewState.Available -> {
                AvailableContent(
                    popularMovies = state.popularMovies,
                    nowPlayingMovies = state.nowPlayingMovies
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
    nowPlayingMovies: List<Movie>
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn {
            items(popularMovies) {
                Text(text = it.title)
            }
        }
        LazyColumn {
            items(nowPlayingMovies) {
                Text(text = it.title)
            }
        }
    }
}