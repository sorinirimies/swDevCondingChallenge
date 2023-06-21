package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.data.remote.dto.toMovie
import de.pirrung.tmbd.challenge.domain.model.details.MovieDetails
import kotlin.math.roundToInt

data class MovieDetailsDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionDto,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("credits")
    val credits: CreditsDto,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
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
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @SerializedName("recommendations")
    val recommendations: RecommendationsDto,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

fun MovieDetailsDto.toMovieDetails() = MovieDetails(
    title = this.title,
    genres = this.genres.map { it.toGenre() },
    overview = this.overview,
    credits = this.credits.toCredits(),
    recommendations = this.recommendations.toRecommendations(),
    posterUrl = StringBuilder(TMDBApi.IMAGE_BASE_URL)
        .append("w342")
        .append(this.posterPath)
        .toString(),
    backdropPosterUrl = StringBuilder(TMDBApi.IMAGE_BASE_URL)
        .append("w1280")
        .append(this.backdropPath)
        .toString(),
    rating = this.voteAverage / 2,
    voteAverage = (this.voteAverage * 10.0).roundToInt() / 10.0,
    voteCount = this.voteCount
)