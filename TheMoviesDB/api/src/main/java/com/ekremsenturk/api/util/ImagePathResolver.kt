package com.ekremsenturk.api.util

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

fun resolvePosterPath(posterPath: String): String {
    return resolvePath("w342", posterPath)
}

fun resolveBackdropPath(backdropPath: String): String {
    return resolvePath("w1280", backdropPath)
}

fun resolveProfilePath(profilePath: String): String {
    return resolvePath("w185", profilePath)
}

private fun resolvePath(imageSize: String, imagePath: String): String {
    return StringBuilder(IMAGE_BASE_URL).append(imageSize).append(imagePath).toString()
}