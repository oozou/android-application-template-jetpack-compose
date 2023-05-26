package com.kbank.dafund.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.kbank.dafund.Secrets
import com.kbank.dafund.core.designsystem.theme.DafundTheme

class SecretKeysViewerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
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
                        item { Text(text = "Secret Keys", style = MaterialTheme.typography.headlineSmall) }
                        item { Text(Secrets().getApiKey1("com.kbank.dafund")) }
                        item { Text(Secrets().getApiKey1("com.kbank.dafund")) }
                        item { Text(Secrets().getBaseAPIUrl1("com.kbank.dafund")) }
                        item { Text(Secrets().getApiTLSPublicKeys("com.kbank.dafund")) }
                    }
                }
            }
        }
    }
}
