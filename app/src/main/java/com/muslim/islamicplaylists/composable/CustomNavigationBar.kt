package com.muslim.islamicplaylists.composable

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.LayoutDirection
import com.muslim.islamicplaylists.R

@Composable
fun CustomNavigationBar(
    state : String ,
    onClick:(String)->Unit
){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        NavigationBar {
            CustomNavigationBarItem(
                state =state,
                selectedItem = "Home",
                onClick = onClick,
                text = stringResource(R.string.home_page),
                icon = ImageVector.vectorResource(R.drawable.home),
            )
            CustomNavigationBarItem(
                state=state,
                selectedItem = "newVideo" ,
                onClick = onClick,
                text = stringResource(R.string.every_thing_new),
                icon = ImageVector.vectorResource(R.drawable.video),
            )
            CustomNavigationBarItem(
                state=state,
                selectedItem = "favorite" ,
                onClick = onClick,
                text = stringResource(R.string.favorite),
                icon =ImageVector.vectorResource(R.drawable.star),
            )
            CustomNavigationBarItem(
                state=state,
                selectedItem = "download" ,
                onClick = onClick,
                text = stringResource(R.string.downloads),
                icon = ImageVector.vectorResource(R.drawable.download),
            )
            CustomNavigationBarItem(
                state=state,
                selectedItem = "Settings" ,
                onClick = onClick,
                text = stringResource(R.string.settings),
                icon = ImageVector.vectorResource(R.drawable.settings),
            )

        }
    }
}