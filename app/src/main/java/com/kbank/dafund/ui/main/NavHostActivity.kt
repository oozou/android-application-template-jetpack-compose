package com.kbank.dafund.ui.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kbank.dafund.core.designsystem.theme.DafundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        setContent {
            DafundTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
        // TODO: IT Security requirement 6.17 The mobile application must implement a rigorous root/jailbreak detection, and respond to the presence of a compromised device by terminating itself, or by appropriate means.
    }
}
