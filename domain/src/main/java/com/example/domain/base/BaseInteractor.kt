package com.example.domain.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseInteractor {
    private val ioDispatcher = Dispatchers.IO

    protected suspend fun <T> withIOContext(block: (suspend CoroutineScope.() -> T)): T {
        return withContext(ioDispatcher) {
            block()
        }
    }
}