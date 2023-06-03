package de.pirrung.tmbd.challenge.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails
import de.pirrung.tmbd.challenge.presentation.details.components.DetailsContent

@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    state: DetailsViewState,
) {
    DetailContent(
        modifier = modifier,
        state = state
    )
}

@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    state: DetailsViewState
) {
    Box(
        modifier = modifier,
    ) {
        when (state) {
            is DetailsViewState.Loading -> {
                LoadingContent(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
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
        modifier = modifier,
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
        DetailsContent(
            modifier = Modifier
                .fillMaxSize(),
            details = details
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