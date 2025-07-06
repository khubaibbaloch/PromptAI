package com.promptai.app.presentation.screens.templatesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.R
import com.promptai.app.data.model.PromptTemplate
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor
import androidx.compose.runtime.*

@Composable
fun TemplatesPromptCard(
    prompt: PromptTemplate,
    onMoreClick: () -> Unit
) {
    var shouldShowMore by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .border(1.dp, OutlineColor, RoundedCornerShape(12.dp))
            .padding(top = 8.dp, end = 8.dp, start = 8.dp, bottom = 4.dp)
    ) {
        val textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, color = TextColor)

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = prompt.description,
                style = textStyle,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 14.sp,
                modifier = Modifier
                    .weight(1f),
                onTextLayout = { layoutResult ->
                    // Show button only if text was ellipsized (i.e., more than 10 lines)
                    shouldShowMore = layoutResult.hasVisualOverflow
                }
            )

            if (shouldShowMore) {
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
            IconButton(onClick = { }, modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_reshare_icon),
                    contentDescription = "Bookmark",
                    tint = PrimaryColor,
                    modifier = Modifier.size(15.dp)
                )
            }
            IconButton(onClick = { }, modifier = Modifier.size(25.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bold_save_icon),
                    contentDescription = "Share",
                    tint = PrimaryColor,
                    modifier = Modifier.size(12.dp)
                )
            }
            IconButton(onClick = { }, modifier = Modifier.size(25.dp)) {
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
