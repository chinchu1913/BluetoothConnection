package com.example.bluetoothconnection.presentation

import com.example.bluetoothconnection.domain.chat.BluetoothDevice

data class BluetoothUiState(val scannedDevice:List<BluetoothDevice> = emptyList(),val pairedDevices:List<BluetoothDevice> = emptyList())
