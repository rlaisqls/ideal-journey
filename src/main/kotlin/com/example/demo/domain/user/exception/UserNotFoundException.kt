package com.example.demo.domain.user.exception

import com.example.demo.global.error.BusinessException
import com.example.demo.global.error.ErrorCode

class UserNotFoundException private constructor() : BusinessException(ErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}