package com.muslim.islamicplaylists.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.muslim.islamicplaylists.ui.theme.Green
import com.muslim.islamicplaylists.ui.theme.TransparentColor


@Composable
fun RowScope.CustomNavigationBarItem(
    state:String,
    selectedItem:String,
    onClick:(String)->Unit,
    text:String,
    icon : ImageVector,
    contentDescription : String? = null
){
    NavigationBarItem(
        selected = selectedItem == state,
        onClick = { onClick( selectedItem ) },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
        },
        alwaysShowLabel = selectedItem == state ,
        label = {
                Text(
                    text = text,
                    textAlign = TextAlign.Center
                )

        },
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = Green ,
            selectedIconColor = Green,
            indicatorColor = TransparentColor,
        )
    )
}