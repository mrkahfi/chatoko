package com.yanmii.chatoko.components

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import com.yanmii.chatoko.theme.ChatokoTheme

@Composable
fun ChatokoDrawer(
    drawerState: DrawerState = rememberDrawerState(initialValue = Closed),
    onProfileClicked: (String) -> Unit,
    onChatClicked: (String) -> Unit,
    content: @Composable () -> Unit
) {
    ChatokoTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    ChatokoDrawerContent(
                        onProfileClicked = onProfileClicked,
                        onChatClicked = onChatClicked
                    )
                }
            },
            content = content
        )
    }
}
