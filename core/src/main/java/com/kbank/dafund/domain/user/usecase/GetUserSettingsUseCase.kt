package com.kbank.dafund.domain.user.usecase

import com.kbank.dafund.domain.user.models.UserSettings
import com.kbank.dafund.domain.user.repository.UserSettingRepository

class GetUserSettingsUseCase constructor(private val repository: UserSettingRepository) {

    suspend operator fun invoke(): UserSettings? = repository.getUserSettings()
}
