package com.yanmii.chatoko.presenter.merchants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.yanmii.chatoko.presenter.merchants.maps.MapsScreen

@Composable
fun MerchantsScreen(
    currentPosition: LatLng,
    modifier: Modifier = Modifier
) {

    val viewModel: MerchantsViewModel = viewModel()
    val merchantsUiState = viewModel.uiState.collectAsState().value

    val navigationItemContentList = listOf(
        NavigationItemContent(
            icon = Icons.Default.Map,
            showType = ShowType.Maps
        ),
        NavigationItemContent(
            icon = Icons.Default.List,
            showType = ShowType.List
        ),
    )

    MerchantsContent(
        currentPosition = currentPosition,
        replyUiState = merchantsUiState,
        onTabPressed = { showType: ShowType ->
            viewModel.updateCurrentShow(showType = showType)
            viewModel.resetHomeScreenStates()
        },
        navigationItemContentList = navigationItemContentList,
        modifier = modifier
    )
}

@Composable
private fun MerchantsContent(
    currentPosition: LatLng,
    replyUiState: MerchantsUiState,
    onTabPressed: ((ShowType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    val cameraState = rememberCameraPositionState()

    LaunchedEffect(key1 = currentPosition) {
        cameraState.animate(
            update = CameraUpdateFactory.newLatLngZoom(
                currentPosition,
                18f
            ),
            durationMs = 1500
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inverseOnSurface),
        verticalArrangement = Arrangement.Bottom,
    ) {
        MapsScreen(
            currentPosition = currentPosition,
            cameraState = cameraState,
            modifier = modifier
                .weight(1f),
        )
        BottomNavBar(
            currentTab = replyUiState.currentShowType,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@Composable
private fun BottomNavBar(
    modifier: Modifier = Modifier,
    onTabPressed: ((ShowType) -> Unit),
    currentTab: ShowType = ShowType.Maps,
    navigationItemContentList: List<NavigationItemContent>,
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.showType,
                onClick = { onTabPressed(navItem.showType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.showType.name
                    )
                }
            )
        }
    }
}

private data class NavigationItemContent(
    val icon: ImageVector,
    val showType: ShowType
)
