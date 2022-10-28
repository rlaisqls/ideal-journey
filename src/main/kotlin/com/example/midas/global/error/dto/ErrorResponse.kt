package com.example.midas.global.error.dto

import com.example.midas.global.error.ErrorCode


data class ErrorResponse(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(errorCode: ErrorCode) = ErrorResponse(
            status = errorCode.status,
            message = errorCode.message
        )
    }
}