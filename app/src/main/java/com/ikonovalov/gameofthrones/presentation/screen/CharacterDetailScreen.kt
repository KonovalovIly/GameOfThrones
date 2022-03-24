package com.ikonovalov.gameofthrones.presentation.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import coil.annotation.ExperimentalCoilApi
import com.ikonovalov.gameofthrones.presentation.components.CharacterDetailCard
import com.ikonovalov.gameofthrones.presentation.components.ErrorScreen
import com.ikonovalov.gameofthrones.presentation.components.LoadingScreen
import com.ikonovalov.gameofthrones.presentation.state.CharacterDetailState
import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel

@ExperimentalCoilApi
@Composable
fun CharacterDetailScreen(viewModel: DetailViewModel, id: String?) {
    viewModel.getCharacterDetail(id)

    when (val result = viewModel.characterDetail.collectAsState().value) {
        CharacterDetailState.Empty -> Text("No JSON!")
        is CharacterDetailState.Error -> ErrorScreen(errorMessage = result.exception.message) {
            viewModel.updateResponse()
        }
        CharacterDetailState.Loading -> LoadingScreen()
        is CharacterDetailState.Success -> {
            val character = result.data
            CharacterDetailCard(
                imageUrl = character.image,
                family = character.family,
                fullName = character.fullName,
                title = character.title
            )
        }
    }

}