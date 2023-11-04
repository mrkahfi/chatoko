package com.yanmii.chatoko.features.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yanmii.chatoko.data.colleagueProfile
import com.yanmii.chatoko.data.meProfile
import com.yanmii.chatoko.ui.theme.ChatokoTheme

@Preview(widthDp = 340, name = "340 width - Me")
@Composable
fun ProfilePreview340() {
    ChatokoTheme {
        ProfileScreen(meProfile)
    }
}

@Preview(widthDp = 480, name = "480 width - Me")
@Composable
fun ProfilePreview480Me() {
    ChatokoTheme {
        ProfileScreen(meProfile)
    }
}

@Preview(widthDp = 480, name = "480 width - Other")
@Composable
fun ProfilePreview480Other() {
    ChatokoTheme {
        ProfileScreen(colleagueProfile)
    }
}
@Preview(widthDp = 340, name = "340 width - Me - Dark")
@Composable
fun ProfilePreview340MeDark() {
    ChatokoTheme {
        ProfileScreen(meProfile)
    }
}

@Preview(widthDp = 480, name = "480 width - Me - Dark")
@Composable
fun ProfilePreview480MeDark() {
    ChatokoTheme {
        ProfileScreen(meProfile)
    }
}

@Preview(widthDp = 480, name = "480 width - Other - Dark")
@Composable
fun ProfilePreview480OtherDark() {
    ChatokoTheme {
        ProfileScreen(colleagueProfile)
    }
}
