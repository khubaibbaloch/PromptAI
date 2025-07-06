package com.promptai.app.presentation.screens.savedPromptScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun SavedPromptSearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = IconColor
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedBorderColor = OutlineColor,
            unfocusedBorderColor = OutlineColor,
            focusedTextColor = TextColor,
            unfocusedTextColor = TextColor
        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
        placeholder = { Text("Search for prompts", color = IconColor) }
    )
}
