package com.ikonovalov.gameofthrones.domain

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getCharactersList(): Flow<List<CharacterWithImage>>
}