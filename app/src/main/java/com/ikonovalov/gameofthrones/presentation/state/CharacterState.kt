package com.ikonovalov.gameofthrones.presentation.state

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow

sealed class CharacterState {
    object Empty : CharacterState()
    object Loading : CharacterState()
    data class Success(val data: List<CharacterWithImage>) : CharacterState()
    data class Error(val exception: Throwable) : CharacterState()
}
