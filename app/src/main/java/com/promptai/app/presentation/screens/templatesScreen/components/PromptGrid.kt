package com.promptai.app.presentation.screens.templatesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.presentation.navigation.ScreenRoutes
import com.promptai.app.ui.theme.TextColor


@Composable
fun PromptGrid(prompts: List<PromptTemplate>, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 80.dp)
    ) {
        items(prompts) { prompt ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                TemplatesPromptCard(
                    prompt = prompt,
                    onMoreClick = {
                        navController.navigate(ScreenRoutes.PromptDetailScreen.routes)
                    }
                )
                Text(
                    text = "Personal Development",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = TextColor
                    ),
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                )
            }
        }
    }
}

