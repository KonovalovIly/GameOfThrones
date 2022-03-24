package com.ikonovalov.gameofthrones.domain.usecases

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): List<CharacterWithImage> = repository.getCharactersList()
}