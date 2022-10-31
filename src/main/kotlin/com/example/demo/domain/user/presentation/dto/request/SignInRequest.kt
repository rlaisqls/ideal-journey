package com.example.demo.domain.user.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

data class SignInRequest (

    @field:NotNull(message = "username은 null이어선 안됩니다")
    @field:Length(min = 1, max = 15, message = "username은 15자 이하여야 합니다.")
    val username: String,

    @field:NotNull(message = "password는 null이어선 안됩니다")
    @field:Length(min = 1, max = 30, message = "password는 8자 이상, 30자 이하여야 합니다.")
    val password: String
)