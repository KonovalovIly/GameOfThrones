package com.ikonovalov.gameofthrones.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ikonovalov.gameofthrones.presentation.screen.CharacterListScreen

object EndPoint {
    const val FULLNAME = "id"
}

@SuppressLint("RememberReturnType")
@Composable
fun NavGraph() {
    val navigationController = rememberNavController()
    val actions = remember(navigationController) { Actions(navigationController) }

    NavHost(navController = navigationController, startDestination = Screen.CharacterList.route) {

        // All character list
        composable(Screen.CharacterList.route) {
            CharacterListScreen(actions)
        }

    }

}
