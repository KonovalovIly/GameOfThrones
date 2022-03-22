package com.ikonovalov.gameofthrones.domain

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getCharactersList(): List<CharacterWithImage>

    suspend fun getCharacter(id: Int): CharacterWithImage
}