package com.ikonovalov.gameofthrones.domain.usecases

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(id: Int): Single<CharacterWithImage> = repository.getCharacter(id)
}