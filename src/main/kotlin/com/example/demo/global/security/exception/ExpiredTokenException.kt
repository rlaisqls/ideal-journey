package com.example.demo.global.security.exception

import com.example.demo.global.error.BusinessException
import com.example.demo.global.error.ErrorCode


class ExpiredTokenException private constructor() : BusinessException(ErrorCode.EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}