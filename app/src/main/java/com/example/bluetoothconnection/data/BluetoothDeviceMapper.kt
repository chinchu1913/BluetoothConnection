package com.example.bluetoothconnection.data


import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.bluetoothconnection.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain():BluetoothDeviceDomain{
    return BluetoothDeviceDomain(name=name, address = address)
}