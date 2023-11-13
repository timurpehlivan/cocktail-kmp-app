package com.timurpehlivan.cocktail.presentation.feature.saved

import com.timurpehlivan.cocktail.domain.usecase.GetSavedCocktailListUseCase
import com.timurpehlivan.cocktail.presentation.feature.saved.SavedCocktailListEvent.*
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SavedCocktailListViewModel(
    private val getSavedCocktailListUseCase: GetSavedCocktailListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SavedCocktailListState())
    val state = _state.asStateFlow()

    fun onEvent(event: SavedCocktailListEvent) = when (event) {
        GetSavedCocktailList -> getSavedCocktailList()
    }

    private fun getSavedCocktailList() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    cocktailList = null,
                    isLoading = true
                )
            }
            val response = getSavedCocktailListUseCase()
            _state.update {
                it.copy(
                    cocktailList = response,
                    isLoading = false
                )
            }
        }
    }
}