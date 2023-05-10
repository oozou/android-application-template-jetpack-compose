package com.kbank.dafund.domain.user.models

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val id: Int? = null,
    val name: String? = null
    // TODO: TBC
)
