package com.example.bluetoothconnection.di

import android.content.Context
import com.example.bluetoothconnection.data.AndroidBluetoothController
import com.example.bluetoothconnection.domain.chat.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBlueToothController(@ApplicationContext context: Context): BluetoothController {
        return AndroidBluetoothController(context = context)
    }
}