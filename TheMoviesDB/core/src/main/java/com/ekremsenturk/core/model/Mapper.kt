package com.ekremsenturk.core.model

import com.ekremsenturk.api.data.ApiCastMember
import com.ekremsenturk.api.data.ApiCrewMember
import com.ekremsenturk.api.data.ApiMovie
import com.ekremsenturk.api.data.ApiMovieDetails

internal fun ApiMovie.toDomainMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        poster = posterPath
    )
}

internal fun ApiMovieDetails.toDomainMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        poster = posterPath,
        overview = overview,
        title = title,
        releaseDate = releaseDate,
        genres = genres.map { it.name },
        backdrop = backdropPath,
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
        picture = profilePath
    )
}

internal fun ApiCrewMember.toDomainCrewMember(): CrewMember {
    return CrewMember(
        name = name,
        job = job,
        picture = profilePath
    )
}