package com.kbank.dafund.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.kbank.dafund.core.designsystem.component.DafundButton
import com.kbank.dafund.core.designsystem.theme.DafundTheme
import com.kbank.dafund.domain.user.usecase.GetSampleDataUseCase
import com.kbank.dafund.domain.user.usecase.SaveSampleDataUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@AndroidEntryPoint
class SharePrefViewerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DatabaseSampleScreen()
        }
    }
}

data class ScreenUiState(
    var sampleDataPref: String? = null
)

@Composable
private fun DatabaseSampleScreen(
    viewModel: LocalStorageViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    DafundTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Text(text = "Encrypted Share Pref", style = MaterialTheme.typography.headlineSmall) }
                item {
                    Text("Encrypted share saved => " + uiState.sampleDataPref)
                }
                item {
                    TextField(value = viewModel.sampleDataTextField ?: "", onValueChange = {
                        viewModel.updateSampleData(it)
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    DafundButton(onClick = {
                        viewModel.saveSampleData()
                    }) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}

@HiltViewModel
class LocalStorageViewModel @Inject constructor(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val saveSampleDataUseCase: SaveSampleDataUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ScreenUiState(sampleDataPref = getSampleDataUseCase()))
    val uiState: StateFlow<ScreenUiState> = _uiState.asStateFlow()

    var sampleDataTextField by mutableStateOf(getSampleDataUseCase())
        private set

    fun updateSampleData(value: String) {
        sampleDataTextField = value
    }

    fun saveSampleData() {
        saveSampleDataUseCase(sampleDataTextField)
        _uiState.update { currentState ->
            currentState.copy(sampleDataPref = getSampleDataUseCase())
        }
    }
}
