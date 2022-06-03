package com.example.data.base

import androidx.annotation.Keep

@Keep
sealed class ApiResponse<out T : Any?> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : ApiResponse<T>()

    data class Error(val text: String) : ApiResponse<Nothing>()
}