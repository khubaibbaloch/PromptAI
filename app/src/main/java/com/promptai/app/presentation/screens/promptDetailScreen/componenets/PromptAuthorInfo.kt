package com.promptai.app.presentation.screens.promptDetailScreen.componenets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.promptai.app.ui.theme.PrimaryColor

@Composable
fun PromptAuthorInfo(authorName: String) {
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
}
