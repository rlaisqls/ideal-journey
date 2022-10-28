package com.example.midas.global.security.exception

import com.example.midas.global.error.BusinessException
import com.example.midas.global.error.ErrorCode

class InvalidTokenException private constructor() : BusinessException(ErrorCode.INVALID_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}