package com.yanmii.chatoko.data

import com.yanmii.chatoko.R
import com.yanmii.chatoko.data.EMOJIS.EMOJI_WORSHIP
import com.yanmii.chatoko.presenter.conversation.ConversationUiState
import com.yanmii.chatoko.presenter.conversation.Message
import com.yanmii.chatoko.presenter.profile.ProfileScreenState

private val initialMessages = listOf(
    Message(
        "Winda Humayra",
        "Baik kak, $EMOJI_WORSHIP ditunggu kunjungannya, terima kasih!",
        "8:06 PM",
        R.drawable.sticker
    ),
    Message(
        "me",
        "Nanti sore saya kesitu!",
        "8:07 PM"
    ),
    Message(
        "me",
        "XL 2 pieces mbak",
        "8:05 PM"
    ),
    Message(
        "Winda Humayra",
        "Ada ukuran L, XL, dan XXL, yang mana kak?",
        "8:05 PM"
    ),
    Message(
        "Winda Humayra",
        "Saya cek stok dulu ya $EMOJI_WORSHIP",
        "8:04 PM"
    ),
    Message(
        "me",
        "Permisi, batik lengan panjang warna cokat tua ada? Yang motif agak modern",
        "8:03 PM"
    )
)

val exampleUiState = ConversationUiState(
    initialMessages = initialMessages,
    channelName = "Boutique Humayra",
    channelMembers = 10
)

/**
 * Example colleague profile
 */
val colleagueProfile = ProfileScreenState(
    userId = "12345",
    photo = R.drawable.someone_else,
    name = "Winda Humayra",
    status = "Away",
    displayName = "winda",
    position = "Owner at Boutique Humayra",
    twitter = "twitter.com/windahumayra",
    timeZone = "12:25 AM local time (Western Indonesia Time)",
    commonChannels = "2"
)


val meProfile = ProfileScreenState(
    userId = "me",
    photo = R.drawable.kahfi,
    name = "Muhammad R Kahfi",
    status = "Online",
    displayName = "mrkahfi",
    position = "Senior Mobile Dev at Yanmii",
    twitter = "twitter.com/mrkahvi",
    timeZone = "In your timezone",
    commonChannels = null
)

object EMOJIS {
    // EMOJI 15
    const val EMOJI_PINK_HEART = "\uD83E\uDE77"

    // EMOJI 14 🫠
    const val EMOJI_MELTING = "\uD83E\uDEE0"

    // ANDROID 13.1 😶‍🌫️
    const val EMOJI_CLOUDS = "\uD83D\uDE36\u200D\uD83C\uDF2B️"

    // ANDROID 12.0 🦩
    const val EMOJI_FLAMINGO = "\uD83E\uDDA9"

    // ANDROID 12.0  👉
    const val EMOJI_POINTS = " \uD83D\uDC49"


    // ANDROID 13.1 😶‍🌫️
    const val EMOJI_WORSHIP = "\uD83D\uDE4F"
}
