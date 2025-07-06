package com.promptai.app.presentation.screens.communityScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.R
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.presentation.navigation.ScreenRoutes
import com.promptai.app.presentation.screens.communityScreen.components.CommunityCategoryChips
import com.promptai.app.presentation.screens.communityScreen.components.CommunityHeader
import com.promptai.app.presentation.screens.communityScreen.components.CommunityPromptGrid
import com.promptai.app.presentation.screens.communityScreen.components.CommunitySectionHeader
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor
//@Composable
//fun CommunityScreen(navController: NavController) {
//    val prompts = remember {
//        List(6) {
//            PromptTemplate(
//                "Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n" +
//                        "Share a personal story where a mistake or failure taught you an important life lesson. Reflect on it."
//            )
//        }
//    }
//
//    val categories = remember {
//        listOf(
//            "Midjourney Art Prompts", "Blog Writing Prompts",
//            "App Design Prompts", "Dev Tools"
//        )
//    }
//
//    var selectedCategory by rememberSaveable { mutableStateOf(categories[1]) }
//
//    val sections = listOf("Recents", "Most Liked", "Categories")
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentPadding = PaddingValues(bottom = 80.dp)
//    ) {
//        item {
//            Text(
//                text = "Community",
//                style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 22.sp,
//                    color = TextColor
//                ),
//                modifier = Modifier.padding(bottom = 24.dp)
//            )
//
//            OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.Search,
//                        contentDescription = "Search",
//                        tint = IconColor
//                    )
//                },
//                shape = RoundedCornerShape(12.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    focusedBorderColor = OutlineColor,
//                    unfocusedBorderColor = OutlineColor,
//                    focusedTextColor = TextColor,
//                    unfocusedTextColor = TextColor
//                ),
//                textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
//                placeholder = { Text("Search for prompts", color = IconColor) }
//            )
//        }
//
//        sections.forEach { sectionTitle ->
//            item {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 24.dp, bottom = 8.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        text = sectionTitle,
//                        style = MaterialTheme.typography.bodyLarge.copy(
//                            fontWeight = FontWeight.Medium,
//                            fontSize = 14.sp,
//                            color = TextColor
//                        )
//                    )
//                    Text(
//                        text = "See All",
//                        style = MaterialTheme.typography.titleSmall.copy(
//                            fontWeight = FontWeight.Normal,
//                            fontSize = 10.sp,
//                            color = TextColor
//                        ),
//                        modifier = Modifier.clickable {
//                            navController.navigate(ScreenRoutes.PromptSectionScreen.routes)
//                        }
//                    )
//                }
//            }
//
//            if (sectionTitle == "Categories") {
//                item {
//                    LazyRow(
//                        contentPadding = PaddingValues(horizontal = 4.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        items(categories) { category ->
//                            val isSelected = selectedCategory == category
//
//                            FilterChip(
//                                selected = isSelected,
//                                onClick = { selectedCategory = category },
//                                label = {
//                                    Text(
//                                        text = category,
//                                        color = if (isSelected) Color.White else PrimaryColor,
//                                        fontSize = 12.sp
//                                    )
//                                },
//                                colors = FilterChipDefaults.filterChipColors(
//                                    selectedContainerColor = PrimaryColor,
//                                    containerColor = Color.Transparent
//                                ),
//                                shape = RoundedCornerShape(12.dp),
//                                border = BorderStroke(1.dp, PrimaryColor)
//                            )
//                        }
//                    }
//                }
//            }
//
//            item {
//                LazyVerticalGrid(
//                    columns = GridCells.Adaptive(minSize = 140.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .heightIn(max = 600.dp),
//                    horizontalArrangement = Arrangement.spacedBy(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(16.dp),
//                    userScrollEnabled = false,
//                    contentPadding = PaddingValues(vertical = 4.dp)
//                ) {
//                    items(prompts.take(2)) { prompt ->
//                        Column(
//                            modifier = Modifier.fillMaxWidth(),
//                            verticalArrangement = Arrangement.spacedBy(4.dp)
//                        ) {
//                            CommunityPromptCard(
//                                prompt = prompt,
//                                onMoreClick = {   navController.navigate(ScreenRoutes.PromptDetailScreen.routes) }
//                            )
//                            Text(
//                                text = "Personal Development",
//                                style = MaterialTheme.typography.titleSmall.copy(
//                                    fontSize = 12.sp,
//                                    color = PrimaryColor
//                                ),
//                                maxLines = 1,
//                                modifier = Modifier.padding(start = 4.dp)
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//

@Composable
fun CommunityScreen(navController: NavController) {
    val prompts = remember {
        List(6) {
            PromptTemplate(
                "Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n" +
                        "Share a personal story where a mistake or failure taught you an important life lesson. Reflect on it."
            )
        }
    }

    val categories = remember {
        listOf(
            "Midjourney Art Prompts", "Blog Writing Prompts",
            "App Design Prompts", "Dev Tools"
        )
    }

    var selectedCategory by rememberSaveable { mutableStateOf(categories[1]) }
    val sections = listOf("Recents", "Most Liked", "Categories")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        item {
            CommunityHeader()
        }

        sections.forEach { sectionTitle ->
            item {
                CommunitySectionHeader(sectionTitle = sectionTitle, navController = navController)
            }

            if (sectionTitle == "Categories") {
                item {
                    CommunityCategoryChips(categories, selectedCategory) {
                        selectedCategory = it
                    }
                }
            }

            item {
                CommunityPromptGrid(prompts = prompts, navController = navController)
            }
        }
    }
}
