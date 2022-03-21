package com.ikonovalov.gameofthrones.presentation.navigation

sealed class Screen(val route: String){
    object CharacterList: Screen("character_list")
    object CharacterDetail: Screen("character_detail")
}