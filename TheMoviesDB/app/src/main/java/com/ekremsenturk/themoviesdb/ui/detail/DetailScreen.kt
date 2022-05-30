package com.ekremsenturk.themoviesdb.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ekremsenturk.core.model.CastMember
import com.ekremsenturk.core.model.CrewMember
import com.ekremsenturk.themoviesdb.R
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    movieId: Int,
    viewModel: DetailViewModel = getViewModel()
) {
    val uiState = viewModel.detailUiState

    LaunchedEffect(key1 = movieId) {
        viewModel.onStart(movieId)
    }

    DetailScreen(
        modifier = modifier,
        detailUiState = uiState,
        onBackClick = onBackClick
    )
}

@Composable
fun DetailScreen(
    modifier: Modifier,
    detailUiState: DetailUiState,
    onBackClick: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        DetailToolbar(onBackClick = onBackClick)
        if (detailUiState.loading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = detailUiState.backdrop,
                    contentDescription = null
                )
                Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                    AsyncImage(
                        modifier = Modifier.width(120.dp),
                        model = detailUiState.poster,
                        contentDescription = null
                    )
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(
                            text = detailUiState.title,
                            style = MaterialTheme.typography.h6,
                        )
                        Text(
                            text = detailUiState.genres,
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = detailUiState.overview,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }

            }
            PeopleGallery(cast = detailUiState.cast, crew = detailUiState.crew)
        }
    }
}

@Composable
fun DetailToolbar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Default.ArrowBack, null)
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.detail_screen_toolbar_title),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        })
}

@Composable
fun PeopleGallery(cast: List<CastMember>, crew: List<CrewMember>) {
    Text(
        text = stringResource(id = R.string.detail_screen_cast_and_crew_title),
        modifier = Modifier.padding(vertical = 16.dp).padding(start = 16.dp),
        style = MaterialTheme.typography.h6
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cast) {
            PersonItem(name = it.name, function = it.character, picture = it.picture)
        }
        items(crew) {
            PersonItem(name = it.name, function = it.job, picture = it.picture)
        }
    }
}