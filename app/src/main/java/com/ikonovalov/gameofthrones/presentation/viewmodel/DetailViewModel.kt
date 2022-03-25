package com.ikonovalov.gameofthrones.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterDetailUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterDetailState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(repository: Repository) : ViewModel() {

    private var _viewState= MutableStateFlow<CharacterDetailState> (CharacterDetailState.Loading)
    val characterDetail = _viewState.asStateFlow()

    private val getCharacterDetailUseCase = GetCharacterDetailUseCase(repository)

    private val compositeDisposable = CompositeDisposable()

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
        compositeDisposable.add(
            getCharacterDetailUseCase.invoke(characterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           onSuccess(it)
                },{
                    _viewState.value = CharacterDetailState.Error(it)
                })
        )
    }

    private fun onSuccess(char: CharacterWithImage){
        if (char.id == 0) _viewState.value = CharacterDetailState.Empty
        else _viewState.value = CharacterDetailState.Success(char)
    }

    fun updateResponse() {
        sendResponse()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}