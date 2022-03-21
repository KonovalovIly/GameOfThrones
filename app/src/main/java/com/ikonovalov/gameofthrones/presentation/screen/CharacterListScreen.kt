package com.ikonovalov.gameofthrones.presentation.screen

import androidx.compose.runtime.Composable
import com.ikonovalov.gameofthrones.presentation.components.CharacterCardItem
import com.ikonovalov.gameofthrones.presentation.navigation.Actions

@Composable
fun CharacterListScreen(actions: Actions) {

    CharacterCardItem(
        fullName = "Daenerys Targaryen",
        title = "House Targaryen",
        imageURL = "https://thronesapi.com/assets/images/daenerys.jpg"
    ) {
    }

}