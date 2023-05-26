package com.kbank.dafund.domain.user.usecase.employee

import com.kbank.dafund.domain.user.repository.employee.EmployeeDatabaseRepository
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(private val employeeDatabaseRepository: EmployeeDatabaseRepository) {

    operator fun invoke() = employeeDatabaseRepository.allEmployees
}
