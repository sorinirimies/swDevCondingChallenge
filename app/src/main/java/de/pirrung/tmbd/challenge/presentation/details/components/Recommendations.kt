package de.pirrung.tmbd.challenge.presentation.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.details.Recommendations
import de.pirrung.tmbd.challenge.presentation.overview.components.HorizontalMovieList
import de.pirrung.tmbd.challenge.presentation.overview.components.MovieItemSmall

@Composable
fun Recommendations(
    modifier: Modifier = Modifier,
    recommendations: Recommendations
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.details_recommendation_header),
            style = MaterialTheme.typography.headlineSmall
        )
        HorizontalMovieList(
            modifier = Modifier.fillMaxWidth(),
            movieContent = {
                MovieItemSmall(
                    movie = it,
                )
            },
            movies = recommendations.movies
        )
    }
}