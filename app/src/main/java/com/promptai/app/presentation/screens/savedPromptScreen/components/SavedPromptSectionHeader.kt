package com.promptai.app.presentation.screens.savedPromptScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.TextColor

@Composable
fun SavedPromptSectionHeader(
    sectionTitle: String,
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = TextColor
            )
        )
        Text(
            text = "See All",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = TextColor
            ),
            modifier = Modifier.clickable { onSeeAllClick() }
        )
    }
}
