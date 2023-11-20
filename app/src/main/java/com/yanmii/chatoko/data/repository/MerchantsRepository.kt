package com.yanmii.chatoko.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.yanmii.chatoko.data.models.Merchant
import kotlinx.coroutines.tasks.await


class MerchantsRepository(private val firestore: FirebaseFirestore) {


    suspend fun getMerchants(): Result<List<Merchant>> {
        try {

            val query = firestore.collection("merchants")
                .get().await()
            val documentSnapshot = query.documents
            val merchants = documentSnapshot.map {
                it.toObject(Merchant::class.java)
                    ?: throw IllegalStateException("Error converting document to MyModel")
            }


            return Result.success(merchants)

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

}
