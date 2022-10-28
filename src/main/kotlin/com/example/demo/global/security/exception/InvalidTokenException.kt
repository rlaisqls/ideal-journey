package com.example.demo.global.security.exception

import com.example.demo.global.error.BusinessException
import com.example.demo.global.error.ErrorCode

class InvalidTokenException private constructor() : BusinessException(ErrorCode.INVALID_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}