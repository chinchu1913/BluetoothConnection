package com.example.bluetoothconnection.presentation.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.layout.ModifierLocalPinnableParent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluetoothconnection.domain.chat.BluetoothDevice
import com.example.bluetoothconnection.presentation.BluetoothUiState

@Composable
fun DeviceScreen(state: BluetoothUiState, onStartScan: () -> Unit, onStopScan: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = onStartScan) {
                Text(text = "Start Scan")
            }
            Button(onClick = onStopScan) {
                Text(text = "Stop Scan")
            }
        }

    }
}


@Composable
fun BluetoothDeviceList(
    pairedDevice: List<BluetoothDevice>,
    scannedDevice: List<BluetoothDevice>,
    onClick: (BluetoothDevice) -> Unit,
    modifier: Modifier
) {
    LazyColumn(modifier = modifier)
    {
        item {
            Text(
                text = "PairedDevice",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(pairedDevice) {
            Text(
                text = it.name ?: "No Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(it) }
                    .padding(16.dp)
            )
        }

        item {
            Text(
                text = "Scan Device",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(scannedDevice) {
            Text(
                text = it.name ?: "No Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(it) }
                    .padding(16.dp)
            )
        }
    }


}