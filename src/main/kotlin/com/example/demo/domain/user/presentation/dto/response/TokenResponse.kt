package com.example.demo.domain.user.presentation.dto.response

import java.time.LocalDateTime
import java.util.*

data class TokenResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime
)