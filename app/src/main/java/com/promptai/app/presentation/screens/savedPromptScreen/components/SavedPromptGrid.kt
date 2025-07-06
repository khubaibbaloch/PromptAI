package com.promptai.app.presentation.screens.savedPromptScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.presentation.screens.communityScreen.components.CommunityPromptCard
import com.promptai.app.ui.theme.PrimaryColor

@Composable
fun SavedPromptGrid(
    prompts: List<PromptTemplate>,
    onPromptClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 600.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        userScrollEnabled = false,
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {

        items(prompts) { prompt ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                CommunityPromptCard(
                    prompt = prompt,
                    onMoreClick = { onPromptClick() }
                )
                Text(
                    text = "Personal Development",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        color = PrimaryColor
                    ),
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
