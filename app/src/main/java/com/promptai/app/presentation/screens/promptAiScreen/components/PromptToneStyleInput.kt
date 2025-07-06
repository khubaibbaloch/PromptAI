package com.promptai.app.presentation.screens.promptAiScreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun PromptToneStyleInput(value: String, onChange: (String) -> Unit) {
    Text(
        text = "Tone & Style",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = TextColor
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
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
        textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
        placeholder = { Text("Friendly") }
    )
    Spacer(modifier = Modifier.height(32.dp))
}
