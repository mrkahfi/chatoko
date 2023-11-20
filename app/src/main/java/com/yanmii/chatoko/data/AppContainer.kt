/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanmii.chatoko.data

import com.google.firebase.firestore.FirebaseFirestore
import com.yanmii.chatoko.data.repository.MerchantsRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val merchantsRepository: MerchantsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {

    override val merchantsRepository: MerchantsRepository by lazy {
        MerchantsRepository(FirebaseFirestore.getInstance())
    }
}
