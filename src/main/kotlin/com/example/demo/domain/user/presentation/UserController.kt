package com.example.demo.domain.user.presentation

import com.example.demo.domain.user.presentation.dto.request.SignInRequest
import com.example.demo.domain.user.presentation.dto.request.SignUpRequest
import com.example.demo.domain.user.presentation.dto.response.TokenResponse
import com.example.demo.domain.user.presentation.dto.response.QueryUserInfoResponse
import com.example.demo.domain.user.service.QueryMyInfoService
import com.example.demo.domain.user.service.SignInService
import com.example.demo.domain.user.service.SignUpService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val queryMyInfoService: QueryMyInfoService
) {

    @PostMapping
    fun signUp(request: SignUpRequest): TokenResponse {
        return signUpService.execute(request)
    }

    @PostMapping("/auth")
    fun signIn(request: SignInRequest): TokenResponse {
        return signInService.execute(request)
    }

    @GetMapping
    fun queryMyInfo(): QueryUserInfoResponse {
        return queryMyInfoService.execute()
    }

}