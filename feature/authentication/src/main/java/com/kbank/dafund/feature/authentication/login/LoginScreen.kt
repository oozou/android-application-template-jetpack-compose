package com.kbank.dafund.feature.authentication.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kbank.dafund.feature.authentication.AuthenticationViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: (() -> Unit)? = null,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                authenticationViewModel.login()
                onLoginSuccess?.invoke()
            }
        ) {
            Text(text = "Login")
        }
    }
}
