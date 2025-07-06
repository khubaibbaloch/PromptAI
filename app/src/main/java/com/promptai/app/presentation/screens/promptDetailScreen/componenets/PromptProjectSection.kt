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
fun PromptProjectSection(projectTitle: String) {
    Text(
        text = "Project Title",
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = PrimaryColor
        ),
        modifier = Modifier.padding(top = 8.dp)
    )
    Text(
        text = projectTitle,
        style = MaterialTheme.typography.bodyMedium.copy(
            color = PrimaryColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    )
}
