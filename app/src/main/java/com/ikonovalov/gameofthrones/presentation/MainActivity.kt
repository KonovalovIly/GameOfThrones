package com.ikonovalov.gameofthrones.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.ikonovalov.gameofthrones.presentation.navigation.NavGraph
import com.ikonovalov.gameofthrones.presentation.ui.theme.GameOfThronesTheme

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameOfThronesTheme {
                Surface(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    NavGraph()
                }
            }
        }
    }
}
