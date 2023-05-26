package com.kbank.dafund.domain.user.usecase.employee

import com.kbank.dafund.core.db.Employee
import com.kbank.dafund.domain.user.repository.employee.EmployeeDatabaseRepository
import javax.inject.Inject

class InsertEmployeeUseCase @Inject constructor(private val employeeDatabaseRepository: EmployeeDatabaseRepository) {

    suspend operator fun invoke(employee: Employee) = employeeDatabaseRepository.insertEmployee(employee)
}
