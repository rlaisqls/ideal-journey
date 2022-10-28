package com.example.midas.global.security.auth


import com.example.midas.domain.user.domain.user.repository.UserRepository
import com.example.midas.domain.user.exception.UserNotFoundException
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