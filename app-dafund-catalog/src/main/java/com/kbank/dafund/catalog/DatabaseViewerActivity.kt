package com.kbank.dafund.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.kbank.dafund.core.db.Employee
import com.kbank.dafund.core.designsystem.component.DafundButton
import com.kbank.dafund.core.designsystem.component.ThemePreviews
import com.kbank.dafund.core.designsystem.theme.DafundTheme
import com.kbank.dafund.domain.user.usecase.employee.ClearEmployeesUseCase
import com.kbank.dafund.domain.user.usecase.employee.GetEmployeesUseCase
import com.kbank.dafund.domain.user.usecase.employee.InsertEmployeeUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DatabaseViewerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DatabaseSampleScreen()
        }
    }
}

data class DatabaseScreenUiState(
    var sampleDataPref: String? = null
)

@Composable
private fun DatabaseSampleScreen(
    viewModel: DatabaseViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val employeeList: List<Employee> by viewModel.employeeList.observeAsState(initial = listOf())
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
                item { Text(text = "Sample Secure Room database", style = MaterialTheme.typography.headlineSmall) }
                item {
                    TextField(
                        modifier = Modifier.fillMaxSize(),
                        value = viewModel.sampleDataTextField,
                        onValueChange = {
                            viewModel.sampleDataTextField = it
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        DafundButton(onClick = {
                            viewModel.insertData()
                        }) {
                            Text(text = "Insert")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        DafundButton(onClick = {
                            viewModel.clear()
                        }) {
                            Text(text = "Clear")
                        }
                    }
                }
                items(items = employeeList, itemContent = {
                    EmployeeCard(it)
                })
            }
        }
    }
}

@ThemePreviews
@Composable
fun PreviewEmployeeCard() {
    EmployeeCard(employee = Employee(employeeName = "Hello"))
}

@Composable
fun EmployeeCard(employee: Employee) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text(text = "${employee.id}:${employee.employeeName}")
        }
    }
}

@HiltViewModel
class DatabaseViewModel @Inject constructor(
    private val getEmployeesUseCase: GetEmployeesUseCase,
    private val insertEmployeeUseCase: InsertEmployeeUseCase,
    private val clearEmployeesUseCase: ClearEmployeesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(DatabaseScreenUiState())

    val uiState: StateFlow<DatabaseScreenUiState> = _uiState.asStateFlow()
    val employeeList: LiveData<List<Employee>> = getEmployeesUseCase().map {
        it.sortedByDescending { it.id }
    }

    var sampleDataTextField by mutableStateOf("")

    fun insertData() {
        if (sampleDataTextField.isEmpty()) {
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            insertEmployeeUseCase(
                Employee(
                    employeeName = sampleDataTextField
                )
            )
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            clearEmployeesUseCase()
        }
    }
}
