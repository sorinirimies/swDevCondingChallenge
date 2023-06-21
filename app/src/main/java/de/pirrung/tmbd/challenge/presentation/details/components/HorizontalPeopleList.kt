package de.pirrung.tmbd.challenge.presentation.details.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.pirrung.tmbd.challenge.R
import de.pirrung.tmbd.challenge.domain.model.details.Cast
import de.pirrung.tmbd.challenge.domain.model.details.Crew

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPeopleList(
    modifier: Modifier = Modifier,
    cast: List<Cast>,
    crew: List<Crew>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.details_cast_and_crew_header),
            style = MaterialTheme.typography.headlineSmall
        )
        CompositionLocalProvider(
            LocalOverscrollConfiguration provides null
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = cast,
                    key = { it.id }
                ) { cast ->
                    PeopleItem(
                        profileUrl = cast.profileUrl,
                        realName = cast.name,
                        name = cast.character
                    )
                }
                items(
                    items = crew,
                    key = { it.id }
                ) { crew ->
                    PeopleItem(
                        profileUrl = crew.profileUrl,
                        realName = crew.name,
                        name = crew.job
                    )
                }
            }
        }
    }
}