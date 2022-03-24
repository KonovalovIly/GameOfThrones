package com.ikonovalov.gameofthrones.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterListUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(repository: Repository): ViewModel() {

    private val _viewState = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val characters = _viewState.asStateFlow()

    private val getCharacterListUseCase = GetCharacterListUseCase(repository)

    init{
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch(Dispatchers.Default) {
            Log.d("THREADLIST", this.coroutineContext.toString() + Thread.currentThread().name)
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