package com.promptai.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.promptai.app.presentation.screens.communityScreen.CommunityScreen
import com.promptai.app.presentation.screens.promptAiScreen.PromptAiScreen
import com.promptai.app.presentation.screens.savedPromptScreen.SavedPromptScreen
import com.promptai.app.presentation.screens.templatesScreen.PromptTemplateScreen

@Composable
fun RootNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenRoutes.PromptTemplateScreen.routes
    ) {
        composable(route = ScreenRoutes.PromptAiScreen.routes) {
            PromptAiScreen()
        }
        composable(route = ScreenRoutes.PromptTemplateScreen.routes) {
            PromptTemplateScreen()
        }
        composable(route = ScreenRoutes.CommunityScreen.routes) {
            CommunityScreen()
        }
        composable(route = ScreenRoutes.SavedPromptScreen.routes) {
            SavedPromptScreen()
        }
    }
}