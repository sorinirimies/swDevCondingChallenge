package com.ekremsenturk.core.model

import com.ekremsenturk.api.data.ApiMovie

internal fun ApiMovie.toDomainMovie(): Movie {
    return Movie(
        title = title,
        poster = posterPath
    )
}