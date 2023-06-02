package de.pirrung.tmbd.challenge.presentation.details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Genre(
    modifier: Modifier = Modifier,
    name: String
) {
    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .border(2.dp, MaterialTheme.colorScheme.primary, MaterialTheme.shapes.extraSmall)
                .padding(8.dp),
            text = name
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GenrePreview() {
    Genre(
        name = "Action"
    )
}