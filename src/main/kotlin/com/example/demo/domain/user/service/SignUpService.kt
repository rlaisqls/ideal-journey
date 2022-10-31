package com.example.demo.domain.user.service

import com.example.demo.domain.user.domain.User
import com.example.demo.domain.user.domain.repository.UserRepository
import com.example.demo.domain.user.facade.UserFacade
import com.example.demo.domain.user.presentation.dto.request.SignUpRequest
import com.example.demo.domain.user.presentation.dto.response.TokenResponse
import com.example.demo.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SignUpService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val jwtGenerator: JwtGenerator
) {
    @Transactional
    fun execute(request: SignUpRequest): TokenResponse {

        userFacade.existsByUsername(request.username)

        val user = userRepository.save(
            User(
                username = request.username,
                password = passwordEncoder.encode(request.password)
            )
        )

        return jwtGenerator.generateToken(user.username)
    }
}