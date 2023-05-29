package com.kbank.dafund.feature.setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingViewModel : ViewModel() {

    private val _text = MutableStateFlow("Settings")
    val text: StateFlow<String> = _text.asStateFlow()
}
