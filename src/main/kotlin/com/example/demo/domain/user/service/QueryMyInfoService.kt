package com.example.demo.domain.user.service

import com.example.demo.domain.user.facade.UserFacade
import com.example.demo.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.springframework.stereotype.Service


@Service
class QueryMyInfoService(
    private val userFacade: UserFacade
) {
    fun execute(): QueryUserInfoResponse {

        val user = userFacade.getCurrentUser()
        return QueryUserInfoResponse(
            userId = user.id,
            username = user.username
        )
    }
}