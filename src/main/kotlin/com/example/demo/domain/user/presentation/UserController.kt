package com.example.demo.domain.user.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping
    fun hello(): String {
        return "Hello?"
    }

}
