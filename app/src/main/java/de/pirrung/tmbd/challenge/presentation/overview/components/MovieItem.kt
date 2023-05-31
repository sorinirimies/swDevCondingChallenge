package de.pirrung.tmbd.challenge.presentation.overview.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.Movie

@Composable
fun MovieItemSmall(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (movie: Movie) -> Unit
) {
    Card(
        modifier = modifier
            .clickable {
                onMovieClick(movie)
            }
    ) {
        Column(
            modifier = Modifier
                .width(100.dp)
        ) {
            AsyncImage(
                modifier = Modifier.height(150.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.posterUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.movie_content_description)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = movie.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MovieItemLarge(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieClick: (movie: Movie) -> Unit
) {
    Card(
        modifier = modifier
            .clickable {
                onMovieClick(movie)
            }
    ) {
        Column(
            modifier = Modifier
                .width(178.dp)
        ) {
            AsyncImage(
                modifier = Modifier.height(100.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.backdropPosterUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.movie_content_description)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                text = movie.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}