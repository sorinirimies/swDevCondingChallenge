package com.ekremsenturk.themoviesdb.ui.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ekremsenturk.core.model.Movie
import com.ekremsenturk.themoviesdb.R
import org.koin.androidx.compose.getViewModel

@Composable
fun OverviewRoute(
    modifier: Modifier = Modifier,
    navigateToDetails: (Int) -> Unit,
    viewModel: OverviewViewModel = getViewModel()
) {
    val uiState = viewModel.overviewUiState

    LaunchedEffect(key1 = viewModel) {
        viewModel.onStart()
    }

    OverviewScreen(
        modifier = modifier,
        navigateToDetails = navigateToDetails,
        overviewUiState = uiState
    )
}

@Composable
fun OverviewScreen(
    modifier: Modifier,
    navigateToDetails: (Int) -> Unit,
    overviewUiState: OverviewUiState
) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        OverviewToolbar()
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState(), enabled = true)
        ) {
            HorizontalMovieGallery(
                title = stringResource(id = R.string.overview_screen_popular_movies_title),
                movies = overviewUiState.popularMovies,
                onItemClick = navigateToDetails,
                loading = overviewUiState.loading
            )
            HorizontalMovieGallery(
                title = stringResource(id = R.string.overview_screen_now_playing_movies_title),
                movies = overviewUiState.nowPlayingMovies,
                onItemClick = navigateToDetails,
                loading = overviewUiState.loading
            )
            HorizontalMovieGallery(
                title = stringResource(id = R.string.overview_screen_top_rated_movies_title),
                movies = overviewUiState.topRatedMovies,
                onItemClick = navigateToDetails,
                loading = overviewUiState.loading
            )
            HorizontalMovieGallery(
                title = stringResource(id = R.string.overview_screen_upcoming_movies_title),
                movies = overviewUiState.upcomingMovies,
                onItemClick = navigateToDetails,
                loading = overviewUiState.loading
            )
        }
    }
}

@Composable
fun OverviewToolbar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.overview_screen_toolbar_title)
            )
        })
}

@Composable
fun HorizontalMovieGallery(
    modifier: Modifier = Modifier,
    title: String,
    movies: List<Movie>,
    loading: Boolean,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = title,
            fontSize = 16.sp
        )
        if (loading) {
            CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
        } else if (movies.isEmpty()) {
            Text(
                text = stringResource(id = R.string.overview_screen_movies_empty_text),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(vertical = 60.dp)
            )
        } else {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movies) {
                    MovieItem(
                        id = it.id,
                        title = it.title,
                        picture = it.poster,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    }
}