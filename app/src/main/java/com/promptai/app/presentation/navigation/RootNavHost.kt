package com.promptai.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.promptai.app.presentation.screens.communityScreen.CommunityScreen
import com.promptai.app.presentation.screens.promptAiScreen.PromptAiScreen
import com.promptai.app.presentation.screens.promptDetailScreen.PromptDetailScreen
import com.promptai.app.presentation.screens.promptSectionScreen.PromptSectionScreen
import com.promptai.app.presentation.screens.savedPromptScreen.SavedPromptScreen
import com.promptai.app.presentation.screens.templatesScreen.PromptTemplateScreen
import com.promptai.app.presentation.screens.uploadPromptScreen.UploadPromptScreen

@Composable
fun RootNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenRoutes.PromptAiScreen.routes
    ) {
        composable(route = ScreenRoutes.PromptAiScreen.routes) {
            PromptAiScreen()
        }
        composable(route = ScreenRoutes.PromptTemplateScreen.routes) {
            PromptTemplateScreen(navHostController)
        }
        composable(route = ScreenRoutes.CommunityScreen.routes) {
            CommunityScreen(navHostController)
        }
        composable(route = ScreenRoutes.SavedPromptScreen.routes) {
            SavedPromptScreen(navHostController)
        }
        composable(route = ScreenRoutes.PromptSectionScreen.routes) {
            PromptSectionScreen(navHostController)
        }
        composable(route = ScreenRoutes.UploadPromptScreen.routes) {
            UploadPromptScreen(navHostController)
        }
        composable(route = ScreenRoutes.UploadPromptScreen.routes) {
            UploadPromptScreen(navHostController)
        }
        composable(route = ScreenRoutes.PromptDetailScreen.routes) {
            PromptDetailScreen(navHostController)
        }
    }
}