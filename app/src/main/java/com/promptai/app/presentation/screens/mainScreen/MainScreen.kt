package com.promptai.app.presentation.screens.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star // Using Star as a placeholder for the magic wand
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.presentation.screens.mainScreen.componentes.BottomBar

// MainScreen composable that builds the entire UI
@Composable
fun MainScreen() {

    var promptInput by rememberSaveable { mutableStateOf("Generate Creative Writing Prompt On Artificial Intelligence.") }

    Scaffold(
        bottomBar = {
            BottomBar()
        },
        containerColor = Color(0xFFF9FAFB)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp
                )
        ) {

            Text(
                text = "AI Prompt Assistant",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )


            Text(
                text = "Describe Topic",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )


            OutlinedTextField(
                value = promptInput,
                onValueChange = { promptInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(
                        min = 120.dp,
                        max = 200.dp
                    )
                    .clip(RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                placeholder = { Text("Enter your topic here...") }
            )

            Spacer(modifier = Modifier.height(32.dp)) // Spacer between text field and button

            // "Generate Prompt" Button
            Button(
                onClick = { /* Handle generate prompt click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp) // Fixed height for the button
                    .clip(RoundedCornerShape(12.dp)), // Apply rounded corners to the button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E2A38), // Dark background color for the button
                    contentColor = Color.White // White text color
                ),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Generate Prompt",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}



// Preview function to see the MainScreen in the Android Studio preview
@Preview(showBackground = true, widthDp = 360, heightDp = 700)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
