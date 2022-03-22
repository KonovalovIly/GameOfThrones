package com.ikonovalov.gameofthrones.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.ikonovalov.gameofthrones.di.DaggerAppComponent
import com.ikonovalov.gameofthrones.presentation.screen.CharacterDetailScreen
import com.ikonovalov.gameofthrones.presentation.screen.CharacterListScreen
import com.ikonovalov.gameofthrones.presentation.utils.daggerViewModel
import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel

object EndPoint {
    const val ID = "id"
}

@ExperimentalCoilApi
@SuppressLint("RememberReturnType")
@Composable
fun NavGraph() {
    val navigationController = rememberNavController()
    val actions = remember(navigationController) { Actions(navigationController) }
    val component = DaggerAppComponent.builder().build()


    NavHost(
        navController = navigationController,
        startDestination = NavigationDestination.CharacterList.destination
    ) {

        composable(NavigationDestination.CharacterList.destination) {
            val listViewModel: ListViewModel = daggerViewModel {
                component.getListViewModel()
            }
            CharacterListScreen(actions, listViewModel)
        }

        composable("${NavigationDestination.CharacterDetail.destination}/{id}",
            arguments = listOf(navArgument(EndPoint.ID) { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString(EndPoint.ID)
            val detailViewModel: DetailViewModel = daggerViewModel {
                component.getDetailViewModel()
            }
            CharacterDetailScreen(viewModel = detailViewModel, id = id)
        }

    }

}
