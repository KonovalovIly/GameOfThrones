package com.ikonovalov.gameofthrones.viewmodel

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterDetailUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterDetailState
import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.*
import org.junit.Test
import kotlin.coroutines.CoroutineContext

class DetailViewModelTest : CoroutineScope {

    private val getCharacterDetailUseCase = mockk<GetCharacterDetailUseCase>()
    private val error = IllegalAccessError()
    private val viewModel = DetailViewModel(getCharacterDetailUseCase = getCharacterDetailUseCase)

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined

    @ExperimentalCoroutinesApi
    @Test
    fun `check characterState if answer right`() = runBlocking {

        // глушим ответ
        coEvery {
            getCharacterDetailUseCase.invoke(any())
        } answers {
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
        }
        viewModel.updateResponse()
        val rightState = CharacterDetailState.Success(
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
        delay(1)
        assertEquals(viewModel.characterDetail.value, rightState)
    }

    @Test
    fun `check characterState if answer loading`() = runBlocking {

        viewModel.updateResponse()
        val rightState = CharacterDetailState.Loading
        assertEquals(viewModel.characterDetail.value, rightState)
    }

    @Test
    fun `check characterState if answer error`() = runBlocking {

        coEvery {
            getCharacterDetailUseCase.invoke(any())
        } throws error

        viewModel.updateResponse()
        delay(1)
        val rightState = CharacterDetailState.Error(error)

        assertEquals(viewModel.characterDetail.value, rightState)
    }

    @Test
    fun` id is null `() = runBlocking{
        viewModel.getCharacterDetail(null)
        // Проверяем ответ
        val rightState = CharacterDetailState.Error(IllegalStateException("No id provided"))
        delay(1)
        assertEquals(viewModel.characterDetail.value.toString(), rightState.toString())
    }

}