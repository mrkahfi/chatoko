package com.yanmii.chatoko.presenter.merchants.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.android.gms.maps.model.LatLng
import com.yanmii.chatoko.data.models.Merchant
import com.yanmii.chatoko.presenter.merchants.list.MerchantsListViewState.Failed
import com.yanmii.chatoko.presenter.merchants.list.MerchantsListViewState.Loading
import com.yanmii.chatoko.presenter.merchants.list.MerchantsListViewState.Success
import com.yanmii.chatoko.ui.theme.ChatokoTheme


@Composable
fun ListScreen(modifier: Modifier) {

    val viewModel: ListViewModel = viewModel(factory = ListViewModel.Factory)

    when (val merchantsUiState = viewModel.merchantsListViewState) {
        is Loading -> CircularProgressIndicator()
        is Success -> MerchantsList(merchantsUiState.merchants)
        is Failed -> Box {}
    }


}


@Composable
fun MerchantsList(merchants: List<Merchant>) {

    LazyColumn {
        items(merchants) { merchant ->
            MerchantCard(merchant)
        }
    }
}

@Composable
fun MerchantCard(merchant: Merchant) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(merchant.profileImgUrl).crossfade(true).build(),
                contentDescription = "Merchant photo",
                modifier = Modifier.weight(1f),
            )
            merchant.name?.let { Text(text = it) }
        }
    }
}

@Preview
@Composable
fun MerchantCardPreview() {
    val merchant = Merchant(
        name = "Klinik Assalam",
        address = "Jalan Tarumanegara 14, Gonilan",
        profileImgUrl = "https://4.bp.blogspot.com/-U6Wz0AU5etM/UZWtH46BK-I/AAAAAAAAAPM/wZof3Y8L20M/s1600/IM.jpeg",
        latLng = LatLng(-7.92381923, 110.2938293)
    )
    ChatokoTheme {
        MerchantCard(merchant = merchant)
    }
}