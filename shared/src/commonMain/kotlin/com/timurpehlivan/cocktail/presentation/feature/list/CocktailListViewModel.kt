package com.timurpehlivan.cocktail.presentation.feature.list

import com.timurpehlivan.cocktail.domain.usecase.GetCocktailListUseCase
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListEvent.*
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CocktailListViewModel(
    private val getCocktailListUseCase: GetCocktailListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CocktailListState())
    val state = _state.asStateFlow()

    init {
        onEvent(GetCocktailList)
    }

    fun onEvent(event: CocktailListEvent) {
        when (event) {
            GetCocktailList -> getCocktailList()
        }
    }

    private fun getCocktailList() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    cocktailList = null,
                    isLoading = true,
                    error = null
                )
            }
            val response = getCocktailListUseCase()
            when {
                response.isSuccess -> {
                    _state.update {
                        it.copy(
                            cocktailList = response.getOrThrow().shuffled(),
                            isLoading = false,
                            error = null
                        )
                    }
                }
                response.isFailure -> {
                    _state.update {
                        it.copy(
                            cocktailList = null,
                            isLoading = false,
                            error = response.exceptionOrNull()?.message,
                        )
                    }
                }
            }
        }
    }
}