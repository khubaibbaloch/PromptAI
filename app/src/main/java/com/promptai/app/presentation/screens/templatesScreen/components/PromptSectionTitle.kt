package com.promptai.app.presentation.screens.templatesScreen.components

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
fun PromptSectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = TextColor
        ),
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}
