package com.ikonovalov.gameofthrones.domain.usecases

import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Single<List<CharacterWithImage>> = repository.getCharactersList()
}