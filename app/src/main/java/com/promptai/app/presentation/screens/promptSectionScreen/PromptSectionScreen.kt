package com.promptai.app.presentation.screens.promptSectionScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.R
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.presentation.navigation.ScreenRoutes
import com.promptai.app.presentation.screens.templatesScreen.components.TemplatesPromptCard
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun PromptSectionScreen(navController: NavController) {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val categories = remember {
        listOf(
            "Midjourney Art Prompts",
            "Blog Writing Prompts",
            "App Design Prompts",
            "Dev Tools"
        )
    }
    var selectedCategory by rememberSaveable { mutableStateOf(categories[1]) } // "Blog Writing Prompts" is selected in the image

    val blogWritingPrompts = remember {
        listOf(
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            ),
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            ),
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            ),
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            ),
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            ),
            PromptTemplate(
                "Sure! Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\nIn this post, share a personal story where a mistake or failure taught you an important life lesson. Reflect on what went wrong, how it affected you, and what you learned from the experience."
            )

        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {

        Row(
            modifier = Modifier.padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(25.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bold_left_arrow),
                    contentDescription = "Back",
                    tint = PrimaryColor
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Categories",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = TextColor
                ),

                )
        }


        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
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
            placeholder = { Text("Search for Categories", color = IconColor) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                val isSelected = selectedCategory == category

                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategory = category },
                    label = {
                        Text(
                            text = category,
                            color = if (isSelected) Color.White else PrimaryColor,
                            fontSize = 12.sp
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = PrimaryColor,
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = PrimaryColor
                    )
                )
            }
        }

        Text(
            text = "Blog Writing Prompts",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = TextColor
            ),
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 140.dp),
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(top = 8.dp, bottom = 80.dp)
        ) {
            items(blogWritingPrompts) { prompt ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    TemplatesPromptCard(
                        prompt = prompt,
                        onMoreClick = {
                            navController.navigate(ScreenRoutes.PromptDetailScreen.routes)
                        }
                    )

                    // This is the text below the card (outside the card)
                    Text(
                        text = "Personal Development", // You can dynamically pass this too
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 12.sp,
                            color = TextColor
                        ),
                        maxLines = 1,
                        modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                    )
                }
            }

        }


        Spacer(modifier = Modifier.height(80.dp)) // Add some extra space at the bottom

    }

}
