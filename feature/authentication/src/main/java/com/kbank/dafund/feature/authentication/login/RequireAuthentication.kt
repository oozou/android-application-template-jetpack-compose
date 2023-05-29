package com.kbank.dafund.feature.authentication.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kbank.dafund.feature.authentication.AuthenticationViewModel

@Composable
fun RequireAuthentication(authenticationViewModel: AuthenticationViewModel, content: @Composable () -> Unit) {
    if (authenticationViewModel.isLogin.collectAsStateWithLifecycle().value) {
        content()
    } else {
        LoginScreen(authenticationViewModel = authenticationViewModel)
    }
}
