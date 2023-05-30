package de.pirrung.tmbd.challenge.presentation.overview.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.domain.model.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalMovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        LazyRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(
                items = movies,
                key = {
                    it.id
                }
            ) { movie ->
                MovieItem(movie = movie)
            }
        }
    }
}