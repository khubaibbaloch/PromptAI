package com.promptai.app.presentation.screens.promptSectionScreen.components

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
fun PromptSectionTitle() {
    Text(
        text = "Blog Writing Prompts",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = TextColor
        ),
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}