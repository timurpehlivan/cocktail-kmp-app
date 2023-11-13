package com.timurpehlivan.cocktail.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CocktailDTO(
    @SerialName("idDrink")
    var id: String? = null,
    @SerialName("strDrink")
    var name: String? = null,
    @SerialName("strDrinkAlternate")
    var alternative: String? = null,
    @SerialName("strTags")
    var tags: String? = null,
    @SerialName("strVideo")
    var video: String? = null,
    @SerialName("strCategory")
    var category: String? = null,
    @SerialName("strIBA")
    var strIBA: String? = null,
    @SerialName("strAlcoholic")
    var alcoholic: String? = null,
    @SerialName("strGlass")
    var glass: String? = null,
    @SerialName("strInstructions")
    var instructions: String? = null,
    @SerialName("strInstructionsES")
    var instructionsES: String? = null,
    @SerialName("strInstructionsDE")
    var instructionsDE: String? = null,
    @SerialName("strInstructionsFR")
    var instructionsFR: String? = null,
    @SerialName("strInstructionsIT")
    var instructionsIT: String? = null,
    @SerialName("strInstructionsZH-HANS")
    var instructionsZHHANS: String? = null,
    @SerialName("strInstructionsZH-HANT")
    var instructionsZHHANT: String? = null,
    @SerialName("strDrinkThumb")
    var drinkThumb: String? = null,
    @SerialName("strIngredient1")
    var ingredient1: String? = null,
    @SerialName("strIngredient2")
    var ingredient2: String? = null,
    @SerialName("strIngredient3")
    var ingredient3: String? = null,
    @SerialName("strIngredient4")
    var ingredient4: String? = null,
    @SerialName("strIngredient5")
    var ingredient5: String? = null,
    @SerialName("strIngredient6")
    var ingredient6: String? = null,
    @SerialName("strIngredient7")
    var ingredient7: String? = null,
    @SerialName("strIngredient8")
    var ingredient8: String? = null,
    @SerialName("strIngredient9")
    var ingredient9: String? = null,
    @SerialName("strIngredient10")
    var ingredient10: String? = null,
    @SerialName("strIngredient11")
    var ingredient11: String? = null,
    @SerialName("strIngredient12")
    var ingredient12: String? = null,
    @SerialName("strIngredient13")
    var ingredient13: String? = null,
    @SerialName("strIngredient14")
    var ingredient14: String? = null,
    @SerialName("strIngredient15")
    var ingredient15: String? = null,
    @SerialName("strMeasure1")
    var measure1: String? = null,
    @SerialName("strMeasure2")
    var measure2: String? = null,
    @SerialName("strMeasure3")
    var measure3: String? = null,
    @SerialName("strMeasure4")
    var measure4: String? = null,
    @SerialName("strMeasure5")
    var measure5: String? = null,
    @SerialName("strMeasure6")
    var measure6: String? = null,
    @SerialName("strMeasure7")
    var measure7: String? = null,
    @SerialName("strMeasure8")
    var measure8: String? = null,
    @SerialName("strMeasure9")
    var measure9: String? = null,
    @SerialName("strMeasure10")
    var measure10: String? = null,
    @SerialName("strMeasure11")
    var measure11: String? = null,
    @SerialName("strMeasure12")
    var measure12: String? = null,
    @SerialName("strMeasure13")
    var measure13: String? = null,
    @SerialName("strMeasure14")
    var measure14: String? = null,
    @SerialName("strMeasure15")
    var measure15: String? = null,
    @SerialName("strImageSource")
    var imageSource: String? = null,
    @SerialName("strImageAttribution")
    var imageAttribution: String? = null,
    @SerialName("strCreativeCommonsConfirmed")
    var creativeCommonsConfirmed: String? = null,
    @SerialName("dateModified")
    var dateModified: String? = null
)