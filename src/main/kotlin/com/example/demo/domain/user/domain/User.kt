package com.example.demo.domain.user.domain


import com.example.demo.global.entity.BaseEntity
import javax.persistence.*


@Entity
@Table(name = "user")
class User(

    @Column(name = "user_id", nullable = false)
    override val id: Long = 0,

    @Column(nullable = false, unique = true, length = 15)
    val username: String,

    @Column(nullable = false, length = 60)
    var password: String

): BaseEntity(id)