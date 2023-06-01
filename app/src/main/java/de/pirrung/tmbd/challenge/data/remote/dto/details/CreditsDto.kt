package de.pirrung.tmbd.challenge.data.remote.dto.details


import com.google.gson.annotations.SerializedName
import de.pirrung.tmbd.challenge.domain.model.details.Credits

data class CreditsDto(
    @SerializedName("cast")
    val cast: List<CastDto>,
    @SerializedName("crew")
    val crew: List<CrewDto>
)

fun CreditsDto.toCredits() = Credits(
    cast = this.cast.map { it.toCast() },
    crew = this.crew.map { it.toCrew() }
)