package com.promptai.app.presentation.screens.savedPromptScreen.components

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
fun SavedPromptTopBar() {
    Text(
        text = "Saved",
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            color = TextColor
        ),
        modifier = Modifier.padding(bottom = 24.dp)
    )
}


