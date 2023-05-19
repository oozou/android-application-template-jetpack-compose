package com.kbank.dafund.feature.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val _text = MutableStateFlow("This is search Fragment")
    val text: StateFlow<String> = _text.asStateFlow()
}
