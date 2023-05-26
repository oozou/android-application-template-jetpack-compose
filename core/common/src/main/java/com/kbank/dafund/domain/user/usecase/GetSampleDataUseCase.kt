package com.kbank.dafund.domain.user.usecase

import com.kbank.dafund.domain.user.repository.UserRepository
import javax.inject.Inject

class GetSampleDataUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke() = repository.getSampleData()
}
