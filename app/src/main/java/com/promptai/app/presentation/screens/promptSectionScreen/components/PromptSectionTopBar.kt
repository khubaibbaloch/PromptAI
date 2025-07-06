package com.promptai.app.presentation.screens.promptSectionScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.promptai.app.R
import com.promptai.app.ui.theme.PrimaryColor
import com.promptai.app.ui.theme.TextColor

@Composable
fun PromptSectionTopBar(navController: NavController) {
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
            )
        )
    }
}









