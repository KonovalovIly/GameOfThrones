package com.ikonovalov.gameofthrones.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterDetailUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(repository: Repository) : ViewModel() {

    private val _viewState = MutableStateFlow<CharacterDetailState>(CharacterDetailState.Loading)
    val characterDetail = _viewState.asStateFlow()

    private val getCharacterDetailUseCase = GetCharacterDetailUseCase(repository)

    private var characterId: Int = 0

    private var resultResponse: Boolean = false

    fun getCharacterDetail(id: String?) {
        if (id == null) _viewState.value =
            CharacterDetailState.Error(IllegalStateException("No id provided"))
        else {
            if (characterId != id.toInt()) resultResponse = false
            if (!resultResponse) {
                characterId = id.toInt()
                sendResponse()
            }
        }
    }

    private fun sendResponse() {
        viewModelScope.launch(Dispatchers.Default) {
            Log.d("THREADDETAIL", this.coroutineContext.toString() + Thread.currentThread().name)
            val result = kotlin.runCatching { getCharacterDetailUseCase.invoke(characterId) }
            result.onSuccess { character ->
                _viewState.value = CharacterDetailState.Success(character)
                resultResponse = true
            }
            result.onFailure {
                _viewState.value = CharacterDetailState.Error(it)
            }
        }
    }

    fun updateResponse() {
        sendResponse()
    }
}