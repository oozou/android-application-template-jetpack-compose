package com.kbank.dafund.domain.user.usecase

import com.kbank.dafund.domain.user.repository.UserRepository
import javax.inject.Inject

class SaveSampleDataUseCase @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(value: String?) = repository.saveSampleData(value)
}
