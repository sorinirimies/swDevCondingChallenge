package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.domain.model.details.Genre

data class GenreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

fun GenreDto.toGenre() = Genre(
    name = this.name
)