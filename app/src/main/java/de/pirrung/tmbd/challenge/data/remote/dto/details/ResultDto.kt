package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.data.remote.dto.MovieDto
import de.pirrung.tmbd.challenge.domain.model.Movie

data class ResultDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

fun ResultDto.toMovie() = Movie(
        id = this.id,
        title = this.title,
        posterUrl = StringBuilder(TMDBApi.IMAGE_BASE_URL)
            .append("w342")
            .append(this.posterPath)
            .toString(),
    )