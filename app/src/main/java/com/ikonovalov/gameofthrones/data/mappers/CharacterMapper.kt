package com.ikonovalov.gameofthrones.data.mappers

import com.ikonovalov.gameofthrones.data.entity.CharacterDto
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Single
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun mapCharacterDtoObserverListToEntityListObserver(characterListDto: List<CharacterDto>): List<CharacterWithImage> =
        characterListDto.map { mapCharacterDtoToEntity(it) }


    fun mapCharacterObserverDtoToEntityObserver(characterDto: CharacterDto): CharacterWithImage =
        mapCharacterDtoToEntity(characterDto)

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