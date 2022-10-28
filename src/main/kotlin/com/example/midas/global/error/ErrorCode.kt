package com.example.midas.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: Int,
    val message: String
)  {

    USER_NOT_FOUND(401 , "User Not Found"),

    EXPIRED_TOKEN(401 , "Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),

    BAD_REQUEST(400, "Bad Request"),
    METHOD_NOT_ALLOWED(400, "Method Not Allowed"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}