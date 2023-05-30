package de.pirrung.tmbd.challenge.presentation.overview.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import de.pirrung.tmbd.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.overview_top_app_bar_title)
            )
        }
    )
}