package com.yanmii.chatoko

import android.app.Application
import com.yanmii.chatoko.data.AppContainer
import com.yanmii.chatoko.data.DefaultAppContainer

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ChatokoApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
