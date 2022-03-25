package com.ikonovalov.gameofthrones.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterListUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListViewModel(repository: Repository) : ViewModel() {

    private val _viewState = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val characters = _viewState.asStateFlow()

    private val compositeDisposable = CompositeDisposable()

    private val getCharacterListUseCase = GetCharacterListUseCase(repository)

    init {
        getCharacters()
    }

    @SuppressLint("CheckResult")
    private fun getCharacters() {
        compositeDisposable.add(
            getCharacterListUseCase.invoke()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)
                },{
                    _viewState.value = CharacterState.Error(it)
                })
        )
    }

    private fun onSuccess(list: List<CharacterWithImage>){
        if (list.isEmpty()) _viewState.value = CharacterState.Empty
        else _viewState.value = CharacterState.Success(list)
    }


    fun updateResponse() {
        getCharacters()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}