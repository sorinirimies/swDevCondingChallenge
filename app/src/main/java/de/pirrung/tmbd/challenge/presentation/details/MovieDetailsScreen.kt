package de.pirrung.tmbd.challenge.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.pirrung.tmbd.challenge.domain.model.MovieDetails

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
        Text(
            text = details.title
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