package com.yanmii.chatoko.presenter.merchants

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MerchantsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MerchantsUiState())
    val uiState: StateFlow<MerchantsUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value =
            MerchantsUiState(
                currentShowType = ShowType.Maps,
            )
    }


    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentShow(showType: ShowType) {
        _uiState.update {
            it.copy(
                currentShowType = showType
            )
        }
    }
}