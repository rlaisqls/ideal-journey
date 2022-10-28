package com.example.midas.domain.user.exception

import com.example.midas.global.error.BusinessException
import com.example.midas.global.error.ErrorCode

class UserNotFoundException private constructor() : BusinessException(ErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}