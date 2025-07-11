package com.promptai.app.presentation.screens.uploadPromptScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.TextColor
// Assuming R.drawable.copy_icon, R.drawable.save_icon, R.drawable.share_icon, R.drawable.next_arrow_icon exist
// For preview purposes, we'll use Material Icons or placeholders if R.drawable is not available.
// For a real app, you would need to add these drawables to your res/drawable folder.
import com.promptai.app.R // This import assumes you have an R.java generated by Android Studio
import com.promptai.app.presentation.screens.uploadPromptScreen.components.UploadPromptInputSection
import com.promptai.app.presentation.screens.uploadPromptScreen.components.UploadPromptTopBar
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.PrimaryColor


//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun UploadPromptScreen(navController: NavController) {
//    var projectTitle by rememberSaveable { mutableStateOf("Personal Development") }
//    var projectDescription by rememberSaveable {
//        mutableStateOf(
//            "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience. Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience. Sure! A Lesson I learned the Hard Way."
//        )
//    }
//    var hashtags by rememberSaveable { mutableStateOf("#PersonalDevelopment #SelfImprovement #Growth") }
//    var authorName by rememberSaveable { mutableStateOf("Mohsin Rza") }
//
//    val isKeyboardVisible = WindowInsets.isImeVisible
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Transparent), // Light grey background
//        // .imePadding()
//        //.verticalScroll(rememberScrollState()), // Enable scrolling for the column
//    ) {
//        // Top Bar with Back Arrow and Title
//        Row(
//            modifier = Modifier.padding(bottom = 24.dp),
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(
//                onClick = { navController.popBackStack() },
//                modifier = Modifier.size(25.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.bold_left_arrow),
//                    contentDescription = "Back",
//                    tint = PrimaryColor
//                )
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(
//                text = "Upload Prompt",
//                style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 22.sp,
//                    color = TextColor
//                ),
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp)) // Spacer after the top bar
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Transparent)
//                .imePadding()
//                .verticalScroll(rememberScrollState())
//        ) {
//            // "Project Title" Section
//            Text(
//                text = "Project Title",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//            OutlinedTextField(
//                value = projectTitle,
//                onValueChange = { projectTitle = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                shape = RoundedCornerShape(12.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    errorContainerColor = Color.Transparent,
//                    focusedBorderColor = OutlineColor,
//                    unfocusedBorderColor = OutlineColor,
//                    errorBorderColor = OutlineColor,
//                    disabledBorderColor = OutlineColor,
//                    focusedTextColor = TextColor,
//                    unfocusedTextColor = TextColor
//                ),
//                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//                placeholder = { Text("Enter project title...") }
//            )
//
//            Spacer(modifier = Modifier.height(24.dp)) // Spacer between sections
//
//            // "Project Description" Section
//            Text(
//                text = "Project Description",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//            OutlinedTextField(
//                value = projectDescription,
//                onValueChange = { projectDescription = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .heightIn(min = 200.dp, max = 300.dp), // Adjusted height for description
//                shape = RoundedCornerShape(12.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    errorContainerColor = Color.Transparent,
//                    focusedBorderColor = OutlineColor,
//                    unfocusedBorderColor = OutlineColor,
//                    errorBorderColor = OutlineColor,
//                    disabledBorderColor = OutlineColor,
//                    focusedTextColor = TextColor,
//                    unfocusedTextColor = TextColor
//                ),
//                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//                placeholder = { Text("Enter project description...") }
//            )
//
//            Spacer(modifier = Modifier.height(24.dp)) // Spacer between sections
//
//            // "Hashtags" Section
//            Text(
//                text = "Hashtags",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//            OutlinedTextField(
//                value = hashtags,
//                onValueChange = { hashtags = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                shape = RoundedCornerShape(12.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    errorContainerColor = Color.Transparent,
//                    focusedBorderColor = OutlineColor,
//                    unfocusedBorderColor = OutlineColor,
//                    errorBorderColor = OutlineColor,
//                    disabledBorderColor = OutlineColor,
//                    focusedTextColor = TextColor,
//                    unfocusedTextColor = TextColor
//                ),
//                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//                placeholder = { Text("Enter hashtags...") }
//            )
//
//            Spacer(modifier = Modifier.height(24.dp)) // Spacer between sections
//
//            // "Author Name" Section
//            Text(
//                text = "Author Name",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = authorName,
//                onValueChange = { authorName = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                shape = RoundedCornerShape(12.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    errorContainerColor = Color.Transparent,
//                    focusedBorderColor = OutlineColor,
//                    unfocusedBorderColor = OutlineColor,
//                    errorBorderColor = OutlineColor,
//                    disabledBorderColor = OutlineColor,
//                    focusedTextColor = TextColor,
//                    unfocusedTextColor = TextColor
//                ),
//                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//                placeholder = { Text("Enter author name...") }
//            )
//            Spacer(modifier = Modifier.height(if (isKeyboardVisible) 16.dp else 80.dp))
//        }
//
//    }
//}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UploadPromptScreen(navController: NavController) {
    var projectTitle by rememberSaveable { mutableStateOf("Personal Development") }
    var projectDescription by rememberSaveable {
        mutableStateOf(
            "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience. Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience. Sure! A Lesson I learned the Hard Way."
        )
    }
    var hashtags by rememberSaveable { mutableStateOf("#PersonalDevelopment #SelfImprovement #Growth") }
    var authorName by rememberSaveable { mutableStateOf("Mohsin Rza") }

    val isKeyboardVisible = WindowInsets.isImeVisible

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {
        UploadPromptTopBar(navController)

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .imePadding()
                .verticalScroll(rememberScrollState())
        ) {
            UploadPromptInputSection(
                label = "Project Title",
                value = projectTitle,
                onValueChange = { projectTitle = it },
                height = 56.dp,
                placeholder = "Enter project title..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            UploadPromptInputSection(
                label = "Project Description",
                value = projectDescription,
                onValueChange = { projectDescription = it },
                minHeight = 200.dp,
                maxHeight = 300.dp,
                placeholder = "Enter project description..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            UploadPromptInputSection(
                label = "Hashtags",
                value = hashtags,
                onValueChange = { hashtags = it },
                height = 56.dp,
                placeholder = "Enter hashtags..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            UploadPromptInputSection(
                label = "Author Name",
                value = authorName,
                onValueChange = { authorName = it },
                height = 56.dp,
                placeholder = "Enter author name..."
            )

            Spacer(modifier = Modifier.height(if (isKeyboardVisible) 16.dp else 80.dp))
        }
    }
}

