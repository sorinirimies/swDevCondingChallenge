package com.ekremsenturk.core.model

import com.ekremsenturk.api.data.ApiCastMember
import com.ekremsenturk.api.data.ApiCrewMember
import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.api.data.ApiMovieDetails
import com.ekremsenturk.api.util.resolveBackdropPath
import com.ekremsenturk.api.util.resolvePosterPath
import com.ekremsenturk.api.util.resolveProfilePath

//Mapper extension functions to map from api to domain models.

internal fun ApiMovie.toDomainMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        poster = posterPath?.let { resolvePosterPath(it) }
    )
}

internal fun ApiMovieDetails.toDomainMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        poster = posterPath?.let { resolvePosterPath(it) },
        overview = overview,
        title = title,
        releaseDate = releaseDate,
        genres = genres.map { it.name },
        backdrop = backdropPath?.let { resolveBackdropPath(it) },
        voteCount = voteCount,
        voteAverage = voteAverage,
        cast = credits.cast.map { it.toDomainCastMember() },
        crew = credits.crew.map { it.toDomainCrewMember() }
    )
}

internal fun ApiCastMember.toDomainCastMember(): CastMember {
    return CastMember(
        name = name,
        character = character,
        picture = profilePath?.let { resolveProfilePath(it) }
    )
}

internal fun ApiCrewMember.toDomainCrewMember(): CrewMember {
    return CrewMember(
        name = name,
        job = job,
        picture = profilePath?.let { resolveProfilePath(it) }
    )
}