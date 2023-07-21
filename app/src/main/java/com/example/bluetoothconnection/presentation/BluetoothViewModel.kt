package com.example.bluetoothconnection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluetoothconnection.domain.chat.BluetoothController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class BluetoothViewModel @Inject constructor(private val bluetoothController: BluetoothController) :
    ViewModel() {
    private val _state = MutableStateFlow(BluetoothUiState())
    val state = combine(
        bluetoothController.scannedDevice, bluetoothController.pairedDevice, _state
    ) { scannedDevice, pairedDevice, state ->
        state.copy(scannedDevice = scannedDevice, pairedDevices = pairedDevice)


    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

    fun startScan() {
        bluetoothController.startDiscovery()
    }

    fun stopScan() {
        bluetoothController.stopDiscovery()
    }
}