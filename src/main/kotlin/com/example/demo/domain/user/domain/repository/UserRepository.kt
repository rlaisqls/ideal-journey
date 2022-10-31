package com.example.demo.domain.user.domain.repository

import com.example.demo.domain.user.domain.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long> {

    fun existsUserByUsername(username: String): Boolean

    fun queryUserById(id: Long): User?

    fun queryUserByUsername(username: String): User?

}