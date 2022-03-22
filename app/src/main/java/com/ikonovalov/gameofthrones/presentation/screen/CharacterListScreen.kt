package com.ikonovalov.gameofthrones.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ikonovalov.gameofthrones.R
import com.ikonovalov.gameofthrones.domain.entity.CharacterWithImage
import com.ikonovalov.gameofthrones.presentation.components.CharacterCardItem
import com.ikonovalov.gameofthrones.presentation.components.ErrorScreen
import com.ikonovalov.gameofthrones.presentation.components.LoadingScreen
import com.ikonovalov.gameofthrones.presentation.navigation.Actions
import com.ikonovalov.gameofthrones.presentation.state.CharacterState
import com.ikonovalov.gameofthrones.presentation.ui.theme.typography
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CharacterListScreen(actions: Actions, viewModel: ListViewModel) {

    when (val result = viewModel.characters.collectAsState().value) {
        CharacterState.Empty -> Text("No JSON!")
        is CharacterState.Error -> ErrorScreen(errorMessage = result.exception.message) {
            viewModel.updateResponse()
        }
        CharacterState.Loading -> LoadingScreen()
        is CharacterState.Success -> {
            CharactersList(item = result.data, actions = actions)
        }
    }
}

@Composable
fun CharactersList(item: List<CharacterWithImage>, actions: Actions) {
    LazyColumn() {
        item {
            Text(
                text = stringResource(id = R.string.list_description),
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
                style = typography.h4,
                color = MaterialTheme.colors.primaryVariant
            )
        }
        items(item) { character ->
            CharacterCardItem(
                fullName = character.fullName,
                title = character.title,
                imageURL = character.image
            ) {
                actions.goCharacterDetail.invoke(character.fullName)
            }
        }
    }
}



