package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.data.mappers.CharacterMapper
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: CharacterServiceWithImageApi,private val mapper: CharacterMapper): Repository {

    override suspend fun getCharactersList(): List<CharacterWithImage> = mapper.mapCharacterDtoListToEntityList(api.getCharacters())

    override suspend fun getCharacter(id: Int): CharacterWithImage = mapper.mapCharacterDtoToEntity(api.getCharacterDetail(id))

}