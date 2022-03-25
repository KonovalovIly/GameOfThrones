package com.ikonovalov.gameofthrones.domain

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.reactivex.Single

interface Repository {

    fun getCharactersList(): Single<List<CharacterWithImage>>

    fun getCharacter(id: Int): Single<CharacterWithImage>
}