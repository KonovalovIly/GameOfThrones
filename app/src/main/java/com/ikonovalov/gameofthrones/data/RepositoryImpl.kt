package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.data.mappers.CharacterMapper
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: CharacterServiceWithImageApi,
    private val mapper: CharacterMapper
) : Repository {

    override fun getCharactersList(): Single<List<CharacterWithImage>> =
        api.getCharacters().map { mapper.mapCharacterDtoObserverListToEntityListObserver(it) }


    override fun getCharacter(id: Int): Single<CharacterWithImage> =
        api.getCharacterDetail(id).map { mapper.mapCharacterObserverDtoToEntityObserver(it) }

}

