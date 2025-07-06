package com.promptai.app.presentation.screens.promptDetailScreen.componenets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.PrimaryColor

@Composable
fun PromptHashtagSection(hashtags: String) {
    Text(
        text = "Hashtags",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = PrimaryColor
        ),
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )

    Text(
        text = hashtags,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 14.sp,
            color = PrimaryColor
        )
    )
}
