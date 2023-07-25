package com.example.bluetoothconnection.domain.chat

import com.example.bluetoothconnection.domain.ConnectionResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevice: StateFlow<List<BluetoothDevice>>
    val pairedDevice: StateFlow<List<BluetoothDevice>>

    fun startDiscovery()
    fun stopDiscovery()
    fun release()
    fun startBluetoothServer(): Flow<ConnectionResult>
    fun connectToDevice(device: BluetoothDevice): Flow<ConnectionResult>

    fun closeConnection()

}