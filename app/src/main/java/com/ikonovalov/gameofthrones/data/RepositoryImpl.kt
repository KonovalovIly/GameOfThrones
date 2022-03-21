package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val api: CharacterApiServiceWithImage): Repository {

    override fun getCharactersList(): Flow<List<CharacterWithImage>> = api.getCharacters()

}