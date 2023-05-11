package com.kbank.dafund.domain.user.usecase

import com.kbank.dafund.domain.user.models.UserSettings
import com.kbank.dafund.domain.user.repository.UserSettingRepository
import javax.inject.Inject

class GetUserSettingsUseCase @Inject constructor(private val repository: UserSettingRepository) {

    suspend operator fun invoke(): UserSettings? = repository.getUserSettings()
}
