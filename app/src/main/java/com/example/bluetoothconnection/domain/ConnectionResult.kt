package com.example.bluetoothconnection.domain

sealed interface ConnectionResult{
    object  ConnectionEstablished:ConnectionResult
    data class  Error(val message:String):ConnectionResult
}