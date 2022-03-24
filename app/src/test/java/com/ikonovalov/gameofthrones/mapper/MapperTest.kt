package com.ikonovalov.gameofthrones.mapper

import com.ikonovalov.gameofthrones.data.CharacterServiceWithImageApi
import com.ikonovalov.gameofthrones.data.RepositoryImpl
import com.ikonovalov.gameofthrones.data.entity.CharacterDto
import com.ikonovalov.gameofthrones.data.mappers.CharacterMapper
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MapperTest {

    private val characterMapper = CharacterMapper()

    @Test
    fun `map characterDtoList to entityList`() = runBlocking {

        val api = mockk<CharacterServiceWithImageApi>()

        // Каждый вызов к апи будет возвращать один и тот же ответ
        coEvery {
            api.getCharacters()
        } answers {
            listOf<CharacterDto>(
                CharacterDto(
                    id = 0,
                    firstName = "firstName",
                    lastName = "lastName",
                    fullName = "fullName",
                    title = "title",
                    family = "family",
                    image = "image",
                    imageURL = "imageUrl",
                )
            )
        }

        val repositoryImpl = RepositoryImpl(api, characterMapper)

        val answer = repositoryImpl.getCharactersList()

        val rightAnswer: List<CharacterWithImage> = listOf(
            CharacterWithImage(
                id = 0,
                firstName = "firstName",
                lastName = "lastName",
                fullName = "fullName",
                title = "title",
                family = "family",
                image = "image",
                imageURL = "imageUrl",
            )
        )
        //Проверка маппера на работу
        assertEquals(rightAnswer, answer)
    }

    @Test
    fun `map characterDto to entity`() = runBlocking {

        val api = mockk<CharacterServiceWithImageApi>()

        // Каждый вызов к апи будет возвращать один и тот же ответ
        coEvery {
            api.getCharacterDetail(any())
        } answers {
            CharacterDto(
                id = 0,
                firstName = "firstName",
                lastName = "lastName",
                fullName = "fullName",
                title = "title",
                family = "family",
                image = "image",
                imageURL = "imageUrl",
            )
        }

        val repositoryImpl = RepositoryImpl(api, characterMapper)

        val answer = repositoryImpl.getCharacter(0)

        val rightAnswer = CharacterWithImage(
                id = 0,
                firstName = "firstName",
                lastName = "lastName",
                fullName = "fullName",
                title = "title",
                family = "family",
                image = "image",
                imageURL = "imageUrl",
            )

        //Проверка маппера на работу
        assertEquals(rightAnswer, answer)
    }

}