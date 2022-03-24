package com.ikonovalov.gameofthrones.viewmodel

import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterListUseCase
import com.ikonovalov.gameofthrones.presentation.state.CharacterState
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ListViewModelTest {

    private val getCharacterListUseCase = mockk<GetCharacterListUseCase>()
    private val viewModel = ListViewModel(getCharacterListUseCase = getCharacterListUseCase)
    private val exp = IllegalAccessError()


    @Test
    fun `check characterListState if answer right`() = runBlocking {
        // глушим ответ
        coEvery {
            getCharacterListUseCase.invoke()
        } answers {
            listOf(
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
        }

        viewModel.updateResponse()

        val rightState = CharacterState.Success(
            listOf(
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
        )
        delay(1)
        assertEquals(viewModel.characters.value,rightState)
    }

    @Test
    fun `check characterListState if loading`() {
        val rightState = CharacterState.Loading
        assertEquals(viewModel.characters.value,rightState)
    }

    @Test
    fun `check characterListState if empty`() = runBlocking {

        // глушим ответ
        coEvery { getCharacterListUseCase.invoke() } answers { listOf() }
        viewModel.updateResponse()
        val rightState = CharacterState.Empty

        delay(1)
        assertEquals(viewModel.characters.value,rightState)
    }

    @Test
    fun `check characterListState if error loading`() = runBlocking {

        // глушим ответ
        coEvery { getCharacterListUseCase.invoke() } throws exp

        viewModel.updateResponse()

        delay(1)
        val rightState = CharacterState.Error(exp)

        assertEquals(viewModel.characters.value,rightState)
    }

}