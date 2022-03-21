package com.ikonovalov.gameofthrones.presentation.navigation

import androidx.navigation.NavController

class Actions( navController: NavController) {

    val goCharacterDetail: (String) -> Unit = {
        navController.navigate("${Screen.CharacterDetail.route}/$it")
    }

    val goCharacterList: () -> Unit = {
        navController.navigate(Screen.CharacterList.route)
    }
}