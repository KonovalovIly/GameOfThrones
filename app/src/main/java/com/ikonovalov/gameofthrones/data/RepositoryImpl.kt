package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: CharacterServiceWithImageApi): Repository {

    override suspend fun getCharactersList(): List<CharacterWithImage> = api.getCharacters()

}