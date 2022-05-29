package com.ekremsenturk.themoviesdb.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = getViewModel()
) {
    val uiState = viewModel.detailUiState

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

}