package com.example.demo.domain.user.facade

import com.example.demo.domain.user.domain.User
import com.example.demo.domain.user.domain.repository.UserRepository
import com.example.demo.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val authDetails = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return findByUsername(authDetails.username)!!
    }

    fun findByUsername(username: String): User? {
        return userRepository.queryUserByUsername(username)
    }

    fun existsByUsername(username: String): Boolean {
        return userRepository.existsUserByUsername(username)
    }

}