package com.promptai.app.presentation.screens.promptAiScreen.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.R
import com.promptai.app.ui.theme.IconColor
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun PromptOutputCard(text: String) {
    Spacer(modifier = Modifier.height(24.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .border(1.dp, OutlineColor, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                color = TextColor
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle copy action */ },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.copy_icon),
                    contentDescription = "Copy",
                    tint = IconColor,
                    modifier = Modifier.size(15.dp)
                )
            }

            IconButton(
                onClick = { /* Handle bookmark action */ },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.save_icon),
                    contentDescription = "Bookmark",
                    tint = IconColor,
                    modifier = Modifier.size(15.dp)
                )
            }

            IconButton(
                onClick = { /* Handle share action */ },
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.share_icon),
                    contentDescription = "Share",
                    tint = IconColor,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}
