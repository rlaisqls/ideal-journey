package com.example.demo.domain.user.service

import com.example.demo.domain.user.exception.UserNotFoundException
import com.example.demo.domain.user.facade.UserFacade
import com.example.demo.domain.user.presentation.dto.request.SignInRequest
import com.example.demo.domain.user.presentation.dto.response.TokenResponse
import com.example.demo.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SignInService(
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade,
    private val jwtGenerator: JwtGenerator
) {
    @Transactional
    fun execute(request: SignInRequest): TokenResponse {

        val username = request.username
        val password = request.password

        val user = userFacade.findByUsername(username) ?: throw UserNotFoundException.EXCEPTION

        if(passwordEncoder.matches(password, user.password)) {
            throw UserNotFoundException.EXCEPTION
        }

        return jwtGenerator.generateToken(user.username)
    }
}