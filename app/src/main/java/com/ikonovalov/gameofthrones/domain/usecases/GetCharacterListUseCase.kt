package com.ikonovalov.gameofthrones.domain.usecases

import com.ikonovalov.gameofthrones.domain.Repository

class GetCharacterListUseCase(private val repository: Repository) {

    operator fun invoke() = repository.getCharactersList()

}