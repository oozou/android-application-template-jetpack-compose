package com.kbank.dafund.feature.authentication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthenticationViewModel : ViewModel() {

    private var _isLogin = MutableStateFlow(false)
    val isLogin = _isLogin.asStateFlow()

    fun login() {
        _isLogin.value = true
    }

    fun logout() {
        _isLogin.value = false
    }
}
