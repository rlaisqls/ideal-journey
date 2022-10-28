package com.example.midas.global.security.exception

import com.example.midas.global.error.BusinessException
import com.example.midas.global.error.ErrorCode


class ExpiredTokenException private constructor() : BusinessException(ErrorCode.EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}