package com.ikonovalov.gameofthrones.presentation.navigation

import androidx.navigation.NavController

class Actions(navController: NavController) {

    val goCharacterDetail: (String) -> Unit = {
        navController.navigate("${NavigationDestination.CharacterDetail.destination}/$it")
    }

    val goCharacterList: () -> Unit = {
        navController.navigate(NavigationDestination.CharacterList.destination)
    }
}