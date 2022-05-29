package com.ekremsenturk.themoviesdb.ui.overview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun OverviewRoute(
    modifier: Modifier = Modifier,
    navigateToDetails: (String) -> Unit,
    viewModel: OverviewViewModel = getViewModel()
) {
    val uiState = viewModel.overviewUiState

    OverViewScreen(
        modifier = modifier,
        navigateToDetails = navigateToDetails,
        overviewUiState = uiState
    )
}

@Composable
fun OverViewScreen(
    modifier: Modifier,
    navigateToDetails: (String) -> Unit,
    overviewUiState: OverviewUiState
) {

}