package com.ikonovalov.gameofthrones.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterListUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(private val getCharacterListUseCase: GetCharacterListUseCase): ViewModel() {

    private val _viewState = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val characters = _viewState.asStateFlow()

    init{
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch(Dispatchers.Default) {
            val result = kotlin.runCatching { getCharacterListUseCase.invoke() }
            result.onSuccess { list ->
                if (list.isEmpty()) _viewState.value = CharacterState.Empty
                else _viewState.value = CharacterState.Success(list)
            }
            result.onFailure {
                _viewState.value = CharacterState.Error(it)
            }
        }
    }

    fun updateResponse(){
        getCharacters()
    }

}