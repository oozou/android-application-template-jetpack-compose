package com.kbank.dafund.ui.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        setContent {
            DafundApp()
        }
        // TODO: IT Security requirement 6.17 The mobile application must implement a rigorous root/jailbreak detection, and respond to the presence of a compromised device by terminating itself, or by appropriate means.
    }
}
