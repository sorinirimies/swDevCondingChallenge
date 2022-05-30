package com.ekremsenturk.themoviesdb.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MovieItem(
    id: Int,
    title: String,
    picture: String?,
    onItemClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable { onItemClick(id) }
    ) {
        AsyncImage(
            modifier = Modifier.height(150.dp),
            model = picture,
            contentDescription = null
        )
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}