package com.example.demo.global.security.jwt

import com.example.demo.domain.user.presentation.dto.request.TokenResponse
import com.example.demo.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtGenerator(
    private val securityProperties: SecurityProperties
){

    fun generateToken(username: String): TokenResponse {
        return TokenResponse(
            accessToken = createAccessToken(username),
            accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
        )
    }

    fun createAccessToken(username: String): String {
        return Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(securityProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .setSubject(username)
            .setHeaderParam(Header.JWT_TYPE, JwtProperty.ACCESS)
            .setId(JwtProperty.ACCESS)
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

}