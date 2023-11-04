package com.yanmii.chatoko.presenter.merchants

data class MerchantsUiState(
    val currentShowType: ShowType = ShowType.Maps,
    val isShowingHomepage: Boolean = true
) {
}

enum class ShowType {
    Maps,
    List,
}