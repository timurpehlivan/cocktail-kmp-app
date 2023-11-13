package com.timurpehlivan.cocktail.presentation.feature.detail

import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.usecase.CheckCocktailSavedUseCase
import com.timurpehlivan.cocktail.domain.usecase.DeleteCocktailUseCase
import com.timurpehlivan.cocktail.domain.usecase.GetCocktailDetailUseCase
import com.timurpehlivan.cocktail.domain.usecase.SaveCocktailUseCase
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailEvent.*
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CocktailDetailViewModel(
    private val getCocktailDetailUseCase: GetCocktailDetailUseCase,
    private val checkCocktailSavedUseCase: CheckCocktailSavedUseCase,
    private val saveCocktailUseCase: SaveCocktailUseCase,
    private val deleteCocktailUseCase: DeleteCocktailUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CocktailDetailState())
    val state = _state.asStateFlow()

    fun onEvent(event: CocktailDetailEvent) = when (event) {
        is GetCocktailDetail -> getCocktailDetail(cocktail = event.cocktail)
        is OnButtonClicked -> toggleSaveCocktail(cocktail = event.cocktail)
    }

    private fun getCocktailDetail(cocktail: Cocktail) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    cocktail = null,
                    isSaved = false,
                    isLoading = true,
                    error = null
                )
            }
            val response = getCocktailDetailUseCase(cocktail.name!!)
            when {
                response.isSuccess -> {
                    _state.update {
                        it.copy(
                            cocktail = response.getOrThrow().first(),
                            isSaved = checkCocktailSavedUseCase(cocktail.id),
                            isLoading = false,
                            error = null
                        )
                    }
                }
                response.isFailure -> {
                    _state.update {
                        it.copy(
                            cocktail = null,
                            isSaved = false,
                            isLoading = false,
                            error = response.exceptionOrNull()?.message,
                        )
                    }
                }
            }
        }
    }

    private fun toggleSaveCocktail(cocktail: Cocktail) {
        viewModelScope.launch(Dispatchers.IO) {
            if (state.value.isSaved) {
                deleteCocktail(cocktail.id)
            } else {
                saveCocktail(cocktail)
            }
        }
    }

    private fun saveCocktail(cocktail: Cocktail) {
        viewModelScope.launch(Dispatchers.IO) {
            saveCocktailUseCase(cocktail)
            _state.update {
                it.copy(
                    isSaved = true,
                )
            }
        }
    }

    private fun deleteCocktail(cocktailId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCocktailUseCase(cocktailId)
            _state.update {
                it.copy(
                    isSaved = false,
                )
            }
        }
    }
}