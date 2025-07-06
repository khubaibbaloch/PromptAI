package com.promptai.app.presentation.screens.templatesScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.R
import com.promptai.app.presentation.navigation.ScreenRoutes
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor
import javax.xml.transform.Templates


@Composable
fun PromptTemplateScreen(navController: NavController) {
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

        Text(
            text = "Templates",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = TextColor
            ),
            modifier = Modifier.padding(bottom = 24.dp)
        )

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
            placeholder = { Text("Search for prompts", color = IconColor) }
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

@Composable
fun TemplatesPromptCard(
    prompt: PromptTemplate,
    onMoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .border(1.dp, OutlineColor, RoundedCornerShape(12.dp))
            .padding(top = 8.dp, end = 8.dp, start = 8.dp, bottom = 4.dp)
    ) {
        val textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, color = TextColor)

        // Row with Text and trailing Icon
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = prompt.description,
                style = textStyle,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 14.sp,
                modifier = Modifier
                    .weight(1f)
            )

            IconButton(
                onClick = { onMoreClick() },
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clip(CircleShape)
                    .background(PrimaryColor)
                    .size(18.dp)
                    .align(Alignment.Bottom),

            ) {
                Icon(
                    painter = painterResource(R.drawable.left_arrow_icon), // use your icon
                    contentDescription = "Show More",
                    tint = Color.White,
                    modifier = Modifier.size(10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }, modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_share_icon),
                    contentDescription = "Copy",
                    tint = PrimaryColor,
                    modifier = Modifier.size(12.dp)
                )
            }
            IconButton(onClick = { },modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_reshare_icon),
                    contentDescription = "Bookmark",
                    tint = PrimaryColor,
                    modifier = Modifier.size(15.dp)
                )
            }
            IconButton(onClick = { },modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_save_icon),
                    contentDescription = "Share",
                    tint =PrimaryColor,
                    modifier = Modifier.size(12.dp)
                )
            }
            IconButton(onClick = { },modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_copy_icon),
                    contentDescription = "Share",
                    tint = PrimaryColor,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}


// Data class for a prompt template
data class PromptTemplate(
    val description: String
)


