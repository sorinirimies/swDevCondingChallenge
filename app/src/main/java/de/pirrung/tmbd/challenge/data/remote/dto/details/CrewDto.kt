package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.data.remote.TMDBApi
import de.pirrung.tmbd.challenge.domain.model.details.Cast
import de.pirrung.tmbd.challenge.domain.model.details.Crew

data class CrewDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("credit_id")
    val creditId: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("job")
    val job: String,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
)

fun CrewDto.toCrew() = Crew(
    job = this.job,
    name = this.name,
    profileUrl = StringBuilder(TMDBApi.IMAGE_BASE_URL)
        .append("w185")
        .append(this.profilePath)
        .toString()
)