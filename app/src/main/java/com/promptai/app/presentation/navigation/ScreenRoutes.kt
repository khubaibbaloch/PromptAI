package com.promptai.app.presentation.navigation

sealed class ScreenRoutes(val routes: String) {
    //data object MainScreen: ScreenRoutes(routes = "MainScreen")
    data object PromptAiScreen : ScreenRoutes(routes = "PromptAiScreen")
    data object SavedPromptScreen : ScreenRoutes(routes = "SavedPromptScreen")
    data object PromptTemplateScreen : ScreenRoutes(routes = "PromptTemplateScreen")
    data object CommunityScreen : ScreenRoutes(routes = "CommunityScreen")
    data object PromptSectionScreen : ScreenRoutes(routes = "PromptSectionScreen")
    data object UploadPromptScreen : ScreenRoutes(routes = "UploadPromptScreen")
    data object PromptDetailScreen : ScreenRoutes(routes = "PromptDetailScreen")
}