package com.promptai.app.presentation.screens.promptAiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptGenerateButton
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptOutputCard
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptTitle
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptToneStyleInput
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptTopicInput
import com.promptai.app.presentation.screens.promptAiScreen.components.PromptTypeInput
import com.promptai.app.ui.theme.IconColor

//@Composable
//fun PromptAiScreen() {
//    // State for the text field inputs
//    var describeTopicInput by rememberSaveable { mutableStateOf("Generate Creative Writing Prompt On Artificial Intelligence.") }
//    var typeInput by rememberSaveable { mutableStateOf("Select Type") }
//    var toneStyleInput by rememberSaveable { mutableStateOf("Friendly") }
//    var generatedPromptText by rememberSaveable {
//        mutableStateOf(
//            "In a future where AIs are strictly programmed for function, one art-curating AI begins producing hauntingly beautiful pieces it claims are based on memories. But machines aren't supposed to remember—let alone dream. Write the story from the AI's point of view as it unravels the mystery of its origins."
//        )
//    }
//
//    Column(
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//            .fillMaxSize()
//
//    ) {
//        // "AI Prompt Assistant" Title
//        Text(
//            text = "AI Prompt Assistant",
//            style = MaterialTheme.typography.headlineMedium.copy(
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 22.sp,
//                color = TextColor
//            ),
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//
//        // "Describe Topic" Section
//        Text(
//            text = "Describe Topic",
//            style = MaterialTheme.typography.bodyLarge.copy(
//                fontWeight = FontWeight.Medium,
//                fontSize = 16.sp,
//                color = TextColor
//            ),
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        OutlinedTextField(
//            value = describeTopicInput,
//            onValueChange = { describeTopicInput = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(min = 120.dp, max = 200.dp),
//            shape = RoundedCornerShape(12.dp),
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent,
//                disabledContainerColor = Color.Transparent,
//                errorContainerColor = Color.Transparent,
//                focusedBorderColor = OutlineColor,
//                unfocusedBorderColor = OutlineColor,
//                errorBorderColor = OutlineColor,
//                disabledBorderColor = OutlineColor,
//                focusedTextColor = TextColor,
//                unfocusedTextColor = TextColor
//            ),
//            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
//            placeholder = { Text("Enter your topic here...") }
//        )
//
//
//        Spacer(modifier = Modifier.height(24.dp)) // Spacer between sections
//
//        // "Type" Section
//        Text(
//            text = "Type",
//            style = MaterialTheme.typography.bodyLarge.copy(
//                fontWeight = FontWeight.Medium,
//                fontSize = 16.sp,
//                color = TextColor
//            ),
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        OutlinedTextField(
//            value = typeInput,
//            onValueChange = { typeInput = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp), // Fixed height for this text field
//            shape = RoundedCornerShape(12.dp),
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent,
//                disabledContainerColor = Color.Transparent,
//                errorContainerColor = Color.Transparent,
//                focusedBorderColor = OutlineColor,
//                unfocusedBorderColor = OutlineColor,
//                errorBorderColor = OutlineColor,
//                disabledBorderColor = OutlineColor,
//                focusedTextColor = TextColor,
//                unfocusedTextColor = TextColor
//            ),
//            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
//            placeholder = { Text("Select Type") }
//        )
//
//        Spacer(modifier = Modifier.height(24.dp)) // Spacer between sections
//
//        // "Tone & Style" Section
//        Text(
//            text = "Tone & Style",
//            style = MaterialTheme.typography.bodyLarge.copy(
//                fontWeight = FontWeight.Medium,
//                fontSize = 16.sp,
//                color = TextColor
//            ),
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        OutlinedTextField(
//            value = toneStyleInput,
//            onValueChange = { toneStyleInput = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp), // Fixed height for this text field
//            shape = RoundedCornerShape(12.dp),
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent,
//                disabledContainerColor = Color.Transparent,
//                errorContainerColor = Color.Transparent,
//                focusedBorderColor = OutlineColor,
//                unfocusedBorderColor = OutlineColor,
//                errorBorderColor = OutlineColor,
//                disabledBorderColor = OutlineColor,
//                focusedTextColor = TextColor,
//                unfocusedTextColor = TextColor
//            ),
//            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
//            placeholder = { Text("Friendly") }
//        )
//
//        Spacer(modifier = Modifier.height(32.dp)) // Spacer before the button
//
//        // "Generate Prompt" Button
//        Button(
//            onClick = { /* Handle generate prompt click */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp), // Fixed height for the button
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xFF1E2A38), // Dark background color for the button
//                contentColor = Color.White // White text color
//            ),
//            shape = RoundedCornerShape(12.dp),
//            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
//        ) {
//            Text(
//                text = "Generate Prompt",
//                style = MaterialTheme.typography.titleMedium.copy(
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(24.dp)) // Spacer after the button
//
//        // Generated Prompt Text Section
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(12.dp)) // Rounded corners for the container
//                .background(Color.Transparent) // White background for the generated text section
//                .border(1.dp, OutlineColor, shape = RoundedCornerShape(12.dp))
//                .padding(vertical = 8.dp,horizontal = 16.dp)
//        ) {
//            Text(
//                text = generatedPromptText,
//                style = MaterialTheme.typography.bodyMedium.copy(
//                    fontSize = 14.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End, // Align icons to the end
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                // Copy Icon
//                IconButton(
//                    onClick = { /* Handle copy action */ },
//                    modifier = Modifier.size(30.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.copy_icon),
//                        contentDescription = "Copy",
//                        tint = IconColor,
//                        modifier = Modifier.size(15.dp)
//                    )
//                }
//               // Spacer(modifier = Modifier.width(16.dp)) // Spacer between icons
//                // Bookmark Icon
//                IconButton(
//                    onClick = { /* Handle bookmark action */ },
//                    modifier = Modifier.size(30.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.save_icon),
//                        contentDescription = "Bookmark",
//                        tint = IconColor,
//                        modifier = Modifier.size(15.dp)
//                    )
//                }
//                //Spacer(modifier = Modifier.width(16.dp)) // Spacer between icons
//                // Share Icon
//                IconButton(
//                    onClick = { /* Handle share action */ },
//                    modifier = Modifier.size(30.dp)
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.share_icon),
//                        contentDescription = "Share",
//                        tint = IconColor,
//                        modifier = Modifier.size(15.dp)
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(80.dp))
//    }
//}

@Composable
fun PromptAiScreen() {
    var describeTopicInput by rememberSaveable { mutableStateOf("Generate Creative Writing Prompt On Artificial Intelligence.") }
    var typeInput by rememberSaveable { mutableStateOf("Select Type") }
    var toneStyleInput by rememberSaveable { mutableStateOf("Friendly") }
    var generatedPromptText by rememberSaveable {
        mutableStateOf(
            "In a future where AIs are strictly programmed for function, one art-curating AI begins producing hauntingly beautiful pieces it claims are based on memories. But machines aren't supposed to remember—let alone dream. Write the story from the AI's point of view as it unravels the mystery of its origins."
        )
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        PromptTitle()

        PromptTopicInput(describeTopicInput) { describeTopicInput = it }

        PromptTypeInput(typeInput) { typeInput = it }

        PromptToneStyleInput(toneStyleInput) { toneStyleInput = it }

        PromptGenerateButton()

        PromptOutputCard(generatedPromptText)

        Spacer(modifier = Modifier.height(80.dp))
    }
}
