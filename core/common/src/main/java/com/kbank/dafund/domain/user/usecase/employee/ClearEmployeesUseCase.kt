package com.kbank.dafund.domain.user.usecase.employee

import com.kbank.dafund.domain.user.repository.employee.EmployeeDatabaseRepository
import javax.inject.Inject

class ClearEmployeesUseCase @Inject constructor(private val employeeDatabaseRepository: EmployeeDatabaseRepository) {

    suspend operator fun invoke() = employeeDatabaseRepository.clear()
}
