package com.example.midas.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class SecurityProperties(
    val secretKey: String,
    val accessExp: Long
)