package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.domain.model.details.Recommendations

data class RecommendationsDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun RecommendationsDto.toRecommendations() = Recommendations(
    movies = this.results.map { it.toMovie() }
)