@file:OptIn(ExperimentalMaterial3Api::class)

package com.yanmii.chatoko.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanmii.chatoko.R
import com.yanmii.chatoko.theme.ChatokoTheme

@Composable
fun ChatokoAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onNavIconPressed: () -> Unit = { },
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        actions = actions,
        title = title,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            ChatokoIcon(
                contentDescription = stringResource(id = R.string.navigation_drawer_open),
                modifier = Modifier
                    .size(64.dp)
                    .clickable(onClick = onNavIconPressed)
                    .padding(16.dp)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ChatokoAppBarPreview() {
    ChatokoTheme {
        ChatokoAppBar(title = { Text("Preview!") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ChatokoAppBarPreviewDark() {
    ChatokoTheme(isDarkTheme = true) {
        ChatokoAppBar(title = { Text("Preview!") })
    }
}
