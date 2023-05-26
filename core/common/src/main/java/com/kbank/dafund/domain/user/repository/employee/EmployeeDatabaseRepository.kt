package com.kbank.dafund.domain.user.repository.employee

import com.kbank.dafund.core.db.DafundDatabaseDao
import com.kbank.dafund.core.db.Employee
import javax.inject.Inject

class EmployeeDatabaseRepository @Inject constructor(
    private val databaseDao: DafundDatabaseDao
) {

    val allEmployees = databaseDao.getAllEmployees()

    suspend fun insertEmployee(employee: Employee) {
        databaseDao.insertEmployee(employee)
    }

    suspend fun clear() {
        databaseDao.clearEmployees()
    }
}
