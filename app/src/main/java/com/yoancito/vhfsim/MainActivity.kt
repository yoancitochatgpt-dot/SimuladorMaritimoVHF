package com.yoancito.vhfsim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    VhfSimulatorScreen()
                }
            }
        }
    }
}

@Composable
fun VhfSimulatorScreen() {
    var channel by remember { mutableIntStateOf(16) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Simulador VHF Marítimo",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Canal activo: CH $channel",
            style = MaterialTheme.typography.titleLarge
        )
        Button(onClick = { channel = if (channel == 16) 13 else 16 }) {
            Text(text = if (channel == 16) "Cambiar a CH 13" else "Volver a CH 16")
        }
    }
}
