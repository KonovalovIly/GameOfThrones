package com.ikonovalov.gameofthrones.presentation.state

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage

sealed class CharacterDetailState {
    object Empty : CharacterDetailState()
    object Loading : CharacterDetailState()
    data class Success(val data: CharacterWithImage) : CharacterDetailState()
    data class Error(val exception: Throwable) : CharacterDetailState()
}