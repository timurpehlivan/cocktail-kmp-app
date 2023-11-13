package com.timurpehlivan.cocktail.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceResponseDTO(
    @SerialName("drinks")
    var cocktails: List<CocktailDTO>? = null
)