package com.example.midas.global.error

open class BusinessException(
    val errorCode: ErrorCode
): RuntimeException()