package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CharacterServiceWithImageApi {

    @GET(CHARACTER_RESPONSE)
    suspend fun getCharacters(): List<CharacterWithImage>

    companion object {
        const val CHARACTER_RESPONSE = "api/v2/Characters"
    }
}