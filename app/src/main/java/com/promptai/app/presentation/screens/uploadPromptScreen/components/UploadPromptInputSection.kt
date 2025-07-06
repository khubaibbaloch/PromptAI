package com.promptai.app.presentation.screens.uploadPromptScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun UploadPromptInputSection(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    height: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified,
    placeholder: String
) {
    Text(
        text = label,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = TextColor
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .then(
                when {
                    height != Dp.Unspecified -> Modifier.height(height)
                    minHeight != Dp.Unspecified || maxHeight != Dp.Unspecified ->
                        Modifier.heightIn(min = minHeight, max = maxHeight)
                    else -> Modifier
                }
            ),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            focusedBorderColor = OutlineColor,
            unfocusedBorderColor = OutlineColor,
            errorBorderColor = OutlineColor,
            disabledBorderColor = OutlineColor,
            focusedTextColor = TextColor,
            unfocusedTextColor = TextColor
        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
        placeholder = { Text(placeholder) }
    )
}