package de.pirrung.tmbd.challenge.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails
import de.pirrung.tmbd.challenge.presentation.details.components.RatingBar

@Composable
fun MovieDetailsScreen(
    state: DetailsViewState,
) {
    DetailContent(
        modifier = Modifier
            .fillMaxSize(),
        state = state
    )
}

@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    state: DetailsViewState
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state) {
            is DetailsViewState.Loading -> {
                LoadingContent()
            }

            is DetailsViewState.Available -> {
                AvailableContent(
                    modifier = Modifier.fillMaxSize(),
                    details = state.details
                )
            }

            is DetailsViewState.Error -> {
                ErrorContent(
                    modifier = Modifier.fillMaxSize()
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
    details: MovieDetails
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(details.backdropPosterUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.movie_content_description)
        )
        Text(
            text = details.title
        )
        RatingBar(
            modifier = Modifier.height(20.dp),
            color = MaterialTheme.colorScheme.primary,
            rating = 3.6
        )
    }
}

@Composable
private fun ErrorContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

    }
}