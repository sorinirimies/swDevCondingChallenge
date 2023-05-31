package de.pirrung.tmbd.challenge.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.Movie
import de.pirrung.tmbd.challenge.presentation.overview.components.HorizontalMovieList
import de.pirrung.tmbd.challenge.presentation.overview.components.MovieItemLarge
import de.pirrung.tmbd.challenge.presentation.overview.components.MovieItemSmall
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
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MoviesSmall(
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(id = R.string.overview_now_playing_movies_header),
            movies = nowPlayingMovies
        )
        MoviesSmall(
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(id = R.string.overview_popular_movies_header),
            movies = popularMovies
        )
        MoviesLarge(
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(id = R.string.overview_upcoming_movies_header),
            movies = upcomingMovies
        )
        MoviesSmall(
            modifier = Modifier.fillMaxWidth(),
            header = stringResource(id = R.string.overview_top_rated_movies_header),
            movies = topRatedMovies
        )
    }
}

@Composable
private fun MoviesSmall(
    modifier: Modifier = Modifier,
    header: String,
    movies: List<Movie>
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
            movieContent = { MovieItemSmall(movie = it) }
        )
    }
}

@Composable
private fun MoviesLarge(
    modifier: Modifier = Modifier,
    header: String,
    movies: List<Movie>
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
            movieContent = { MovieItemLarge(movie = it) }
        )
    }
}