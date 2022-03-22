package com.ikonovalov.gameofthrones.domain.usecases

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(id: Int): CharacterWithImage = repository.getCharacter(id)
}