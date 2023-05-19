package com.kbank.dafund.domain.user.usecase

import com.kbank.dafund.domain.user.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): List<String> = repository.getUser()
}
