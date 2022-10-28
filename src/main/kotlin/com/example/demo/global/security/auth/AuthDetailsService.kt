package com.example.demo.global.security.auth


import com.example.demo.domain.user.domain.user.repository.UserRepository
import com.example.demo.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.queryUserByUsername(username) ?: throw UserNotFoundException.EXCEPTION
        return AuthDetails(user.username)
    }

}