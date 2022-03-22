package com.ikonovalov.gameofthrones.presentation.navigation

import androidx.annotation.StringRes
import com.ikonovalov.gameofthrones.R

sealed class NavigationDestination(val destination: String, @StringRes val resourceId: Int){
    object CharacterList: NavigationDestination("character_list", R.string.character_list)
    object CharacterDetail: NavigationDestination("character_detail", R.string.character_detail)
}