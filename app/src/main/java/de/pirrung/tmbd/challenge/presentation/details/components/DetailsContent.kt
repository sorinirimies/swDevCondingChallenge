package de.pirrung.tmbd.challenge.presentation.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.details.Genre
import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    details: MovieDetails,
) {
    Column(
        modifier = modifier,
    ) {
        ImageHeader(details = details)
        Column(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            HorizontalPeopleList(
                modifier = Modifier
                    .fillMaxWidth(),
                cast = details.credits.cast,
                crew = details.credits.crew
            )
            if (details.recommendations.movies.isNotEmpty())
                Recommendations(
                    modifier = Modifier
                        .fillMaxWidth(),
                    recommendations = details.recommendations
                )
        }
    }
}

@Composable
private fun ImageHeader(
    modifier: Modifier = Modifier,
    details: MovieDetails
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
                .drawWithContent {
                    val colors = listOf(
                        Color.Transparent,
                        Color.LightGray
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = colors,
                            startY = this.size.height,
                            endY = this.size.height / 30f
                        ),
                        blendMode = BlendMode.DstIn
                    )
                },
            model = ImageRequest.Builder(LocalContext.current)
                .data(details.backdropPosterUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.movie_content_description)
        )
        HeaderContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
                .offset(y = (-15).dp),
            posterUrl = details.posterUrl,
            title = details.title,
            rating = details.rating,
            voteAverage = details.voteAverage,
            voteCount = details.voteCount,
            genres = details.genres,
            description = details.overview
        )
    }
}

@Composable
private fun HeaderContent(
    modifier: Modifier = Modifier,
    posterUrl: String,
    title: String,
    rating: Double,
    voteAverage: Double,
    voteCount: Int,
    genres: List<Genre>,
    description: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .width(100.dp)
                .height(150.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(posterUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.movie_content_description)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall
            )
            RatingContent(
                modifier = Modifier.fillMaxWidth(),
                rating = rating,
                voteAverage = voteAverage,
                voteCount = voteCount
            )
            GenreContent(
                modifier = Modifier.fillMaxWidth(),
                genres = genres
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun GenreContent(
    modifier: Modifier = Modifier,
    genres: List<Genre>
) {
    if (genres.isNotEmpty()) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            genres.forEachIndexed { index, genre ->
                if (index == 2) return@Row
                GenreItem(name = genre.name)
            }
        }
    }
}

@Composable
private fun RatingContent(
    modifier: Modifier = Modifier,
    rating: Double,
    voteAverage: Double,
    voteCount: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        RatingBar(
            modifier = Modifier
                .height(16.dp)
                .weight(2f, false),
            color = MaterialTheme.colorScheme.primary,
            rating = rating
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "($voteCount)",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.primary
            )
        )
        RatingStar(
            modifier = Modifier
                .height(16.dp),
            rating = 1f,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "$voteAverage",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary
            )
        )
    }
}