package com.example.midas.global.error

import com.example.midas.global.error.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun serverExceptionHandler(e: BusinessException): ErrorResponse = ErrorResponse.of(
        errorCode = e.errorCode
    )

    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun bindExceptionHandler(e: BindException): ErrorResponse = ErrorResponse.of(
        errorCode = ErrorCode.BAD_REQUEST
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException): ErrorResponse = ErrorResponse.of(
        errorCode = ErrorCode.BAD_REQUEST
    )

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleIllegalArgumentException(e: IllegalArgumentException): ErrorResponse = ErrorResponse.of(
        errorCode = ErrorCode.BAD_REQUEST
    )

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception): ErrorResponse {

        println(e.javaClass)
        println(e.message)
        println(e.cause)
        e.stackTrace.map { println(it) }

        return ErrorResponse.of(
            errorCode = ErrorCode.INTERNAL_SERVER_ERROR
        )
    }
}