package com.example.demo.global.error

open class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()