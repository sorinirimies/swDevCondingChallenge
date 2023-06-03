package de.pirrung.tmbd.challenge.presentation.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import de.pirrung.tmbd.challenge.R

@Composable
fun PeopleItem(
    modifier: Modifier = Modifier,
    profileUrl: String,
    realName: String,
    name: String
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .width(78.dp)
                .height(78.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(profileUrl)
                .crossfade(true)
                .error(R.drawable.round_person)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.movie_content_description)
        )
        Text(
            modifier = Modifier.width(78.dp),
            text = realName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.width(78.dp),
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}