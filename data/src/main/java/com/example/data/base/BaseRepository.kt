package com.example.data.base

import com.example.domain.base.NetworkErrorException

abstract class BaseRepository {

    fun <T : Any> handleRestResponse(response: ApiResponse<T>): T {
        return when (response) {
            is ApiResponse.Error -> {
                throw NetworkErrorException(response.text)
            }
            else -> {
                (response as ApiResponse.Success).body
            }
        }
    }
}