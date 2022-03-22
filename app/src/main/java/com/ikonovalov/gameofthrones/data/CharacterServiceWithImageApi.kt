package com.ikonovalov.gameofthrones.data

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterServiceWithImageApi {

    @GET(CHARACTER_LIST_RESPONSE)
    suspend fun getCharacters(): List<CharacterWithImage>


    @GET(CHARACTER_DETAIL_RESPONSE)
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): CharacterWithImage

    companion object {
        const val CHARACTER_LIST_RESPONSE = "api/v2/Characters"
        const val CHARACTER_DETAIL_RESPONSE = "api/v2/Characters/{id}"

    }
}