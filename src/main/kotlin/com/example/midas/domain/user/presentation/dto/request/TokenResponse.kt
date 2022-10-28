package com.example.midas.domain.user.presentation.dto.request

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime
)