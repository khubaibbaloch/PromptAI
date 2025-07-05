package com.promptai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.promptai.app.presentation.screens.mainScreen.MainScreen
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.PromptAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PromptAITheme {

                val navController = rememberNavController()

                // Set status bar color
                val systemUiController = rememberSystemUiController()
                val statusBarColor = PrimaryColor
                val useDarkIcons = false

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = statusBarColor,
                        darkIcons = useDarkIcons
                    )
                }

                MainScreen(navController = navController)
            }
        }
    }
}

