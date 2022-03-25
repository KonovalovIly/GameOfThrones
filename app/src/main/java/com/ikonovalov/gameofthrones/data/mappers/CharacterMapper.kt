package com.ikonovalov.gameofthrones.data.mappers

import com.ikonovalov.gameofthrones.data.entity.CharacterDto
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Single
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun mapCharacterDtoObserverListToEntityListObserver(characterListDto: Single<List<CharacterDto>>): Single<List<CharacterWithImage>> =
        characterListDto.map { list -> list.map { mapCharacterDtoToEntity(it) } }


    fun mapCharacterObserverDtoToEntityObserver(characterDto: Single<CharacterDto>): Single<CharacterWithImage> =
        characterDto.map { char -> mapCharacterDtoToEntity(char) }

    private fun mapCharacterDtoToEntity(characterDto: CharacterDto): CharacterWithImage =
        CharacterWithImage(
            characterDto.id,
            characterDto.firstName,
            characterDto.lastName,
            characterDto.fullName,
            characterDto.title,
            characterDto.family,
            characterDto.image,
            characterDto.imageURL ?: ""
        )

}