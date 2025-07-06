package com.promptai.app.presentation.screens.promptDetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.R // Assuming R.drawable.heart_icon and other icon drawables exist
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.presentation.screens.communityScreen.CommunityPromptCard

import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor // Assuming TextColor is defined in your theme

@Composable
fun PromptDetailScreen(navController: NavController) {
    // Sample data for the screen
    val promptTitle = "Personal Development"
    val authorName = "Mohsin Rza"
    val projectTitleDetail =
        "Personal Development" // This seems to be the category/title for the prompt itself
    val hashtags =
        "#PersonalDevelopment\n#SelfImprovement\n#GrowthMindset\n#BeYourBestSelf\n#BetterEveryDay\n#LevelUp\n#LifelongLearning"


    val prompts = remember {
        List(6) {
            PromptTemplate(
                "Here's a brief description for the blog prompt \"A Lesson I Learned the Hard Way\" in 2-3 lines:\n" +
                        "Share a personal story where a mistake or failure taught you an important life lesson. Reflect on it."
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent) // Light grey background
            .verticalScroll(rememberScrollState()) // Enable scrolling for the column
    ) {
        // Top Bar with Back Arrow and Title
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
                text = "Prompt Detail",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = TextColor
                ),
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Spacer after the top bar

        // Prompt Description Card
        DetailPromptCard(
            prompt = prompts[0],
            onMoreClick = { /* Handle click */ }
        )

        // "Author name" Section
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = PrimaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("Author name: ")
                }

                withStyle(
                    style = SpanStyle(
                        color = PrimaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append(authorName)
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        )


        // "Project Title" Section (referring to the prompt's category/title)
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
            text = projectTitleDetail,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = PrimaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )

        // "Hashtags" Section
        Text(
            text = "Hashtags",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = PrimaryColor
            ),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        Text(
            text = hashtags,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                color = PrimaryColor
            )
        )

        Spacer(modifier = Modifier.height(24.dp)) // Spacer at the bottom
    }
}

@Composable
fun DetailPromptCard(
    prompt: PromptTemplate,
    onMoreClick: () -> Unit
) {
    var isTextOverflowing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .border(1.dp, OutlineColor, RoundedCornerShape(12.dp))
            .padding(top = 8.dp, end = 8.dp, start = 8.dp, bottom = 4.dp)
    ) {
        val textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = 14.sp,
            color = TextColor,
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = prompt.description,
                style = textStyle,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { layoutResult ->
                    // Check if ellipsis (truncation) occurred
                    isTextOverflowing = layoutResult.hasVisualOverflow
                },
                modifier = Modifier
                    .weight(1f)
            )

            if (isTextOverflowing) {
                IconButton(
                    onClick = { onMoreClick() },
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clip(CircleShape)
                        .background(PrimaryColor)
                        .size(18.dp)
                        .align(Alignment.Bottom)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.left_arrow_icon),
                        contentDescription = "Show More",
                        tint = Color.White,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }
        }

        // Action Row (Share, Save, Copy, etc.)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(onClick = { }, modifier = Modifier.size(30.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_share_icon),
                    contentDescription = "Share",
                    tint = PrimaryColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            IconButton(onClick = { }, modifier = Modifier.size(30.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_save_icon),
                    contentDescription = "Save",
                    tint = PrimaryColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            IconButton(onClick = { }, modifier = Modifier.size(30.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_copy_icon),
                    contentDescription = "Copy",
                    tint = PrimaryColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            IconButton(onClick = { }, modifier = Modifier.size(30.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_star_icon),
                    contentDescription = "Star",
                    tint = PrimaryColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            Column(
                modifier = Modifier.padding(bottom = 6.dp, start = 4.dp, top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "5",
                    fontSize = 14.sp,
                    color = TextColor,
                    lineHeight = 1.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.bold_heart_icon),
                    contentDescription = "Like",
                    tint = PrimaryColor,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
