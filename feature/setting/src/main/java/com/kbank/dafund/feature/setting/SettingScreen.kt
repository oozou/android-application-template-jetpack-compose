package com.kbank.dafund.feature.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kbank.dafund.core.designsystem.theme.h1

@Composable
fun SettingScreen(
    isLogin: Boolean,
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit,
    onLogoutButtonClick: () -> Unit,
    viewModel: SettingViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = viewModel.text.collectAsStateWithLifecycle().value,
            style = MaterialTheme.typography.h1
        )
        if (isLogin) {
            Button(onClick = onLogoutButtonClick) {
                Text(text = "Logout")
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedButton(onClick = navigateToLogin) {
                    Text(text = "Login")
                }
                Button(onClick = navigateToRegister) {
                    Text(text = "Register")
                }
            }
        }
    }
}
