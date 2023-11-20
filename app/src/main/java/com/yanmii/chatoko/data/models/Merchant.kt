package com.yanmii.chatoko.data.models

import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.IgnoreExtraProperties


/**
 * Merchant POJO
 */
@IgnoreExtraProperties
data class Merchant(
    val id: String? = null,
    val name: String? = null,
    val profileImgUrl: String? = null,
    val latLng: LatLng? = null,
    val address: String? = null,
) {

    companion object {
        const val FIELD_NAME = "name"
        const val FIELD_IMG_URL = "profile_img_url"
        const val FIELD_LATLNG = "lat_lng"
        const val FIELD_ADDRESS = "address"
    }
}