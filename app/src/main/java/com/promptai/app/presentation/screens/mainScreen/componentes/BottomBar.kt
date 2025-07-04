package com.promptai.app.presentation.screens.mainScreen.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.promptai.app.ui.theme.OutlineColor
import com.promptai.app.ui.theme.PrimaryColor

@Composable
fun BottomBar() {
    val items = remember {
        listOf(
            BottomNavItem(Icons.Filled.Star, "Magic Wand"),
            BottomNavItem(Icons.Filled.Star, "Grid View"),
            BottomNavItem(Icons.Filled.Star, "Groups"),
            BottomNavItem(Icons.Filled.Star, "Bookmark")
        )
    }

    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    BottomAppBar(
        containerColor = Color.Transparent,
        contentColor = Color.White,
        tonalElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 32.dp, end = 32.dp)
                .height(45.dp)
                .clip(CircleShape)
                .background(PrimaryColor),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedItem == index

                // Replace NavigationBarItem with plain Box + clickable
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(35.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) OutlineColor else Color.Transparent)
                        .clickable(
                            indication = null, // No ripple
                            interactionSource = remember { MutableInteractionSource() } // Disable default touch feedback
                        ) {
                            selectedItem = index
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription,
                        modifier = Modifier.size(28.dp),
                        tint = if (isSelected) Color.Black else Color.White
                    )
                }
            }
        }
    }
}


data class BottomNavItem(
    val icon: ImageVector,
    val contentDescription: String
)