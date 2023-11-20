package com.yanmii.chatoko.presenter.merchants.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.yanmii.chatoko.ChatokoApplication
import com.yanmii.chatoko.data.models.Merchant
import com.yanmii.chatoko.data.repository.MerchantsRepository
import kotlinx.coroutines.launch
import java.io.IOException

class ListViewModel(private val merchantsRepository: MerchantsRepository) : ViewModel() {

    var merchantsListViewState: MerchantsListViewState by mutableStateOf(MerchantsListViewState.Loading)
        private set
    init {
        getMerchants()
    }

    /**
     * Gets Merchants information from Firestore DB
     * [Merchant] [List] [MutableList].
     */
    private fun getMerchants() {
        viewModelScope.launch {
            merchantsListViewState = MerchantsListViewState.Loading
            merchantsListViewState = try {
                val result = merchantsRepository.getMerchants()
                MerchantsListViewState.Success(result.getOrThrow())

            } catch (e: IOException) {
                MerchantsListViewState.Failed
            } catch (e: coil.network.HttpException) {
                MerchantsListViewState.Failed
            }
        }
    }


    /**
     * Factory for [ListViewModel] that takes [MerchantsRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ChatokoApplication)
                val merchantsRepository = application.container.merchantsRepository
                ListViewModel(merchantsRepository = merchantsRepository)
            }
        }
    }
}

sealed interface MerchantsListViewState {
    object Loading : MerchantsListViewState
    data class Success(val merchants: List<Merchant>) : MerchantsListViewState
    object Failed : MerchantsListViewState
}
