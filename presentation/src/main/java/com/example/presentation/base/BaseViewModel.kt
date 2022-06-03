package com.example.presentation.base

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.presentation.resourcemanager.ResourceManager
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    @Inject
    internal lateinit var resourceManager: ResourceManager

    protected inline fun launch(
        scope: CoroutineScope,
        crossinline block: suspend CoroutineScope.() -> Unit
    ): Job {
        return (scope + CoroutineExceptionHandler { _, _ -> }).launch(context = Dispatchers.Main) {
            runCatching { block() }
                .exceptionOrNull()
                ?.let { Log.d("launch exception", it.message.toString()) }
        }
    }

    protected inline fun launchIo(
        scope: CoroutineScope,
        crossinline block: suspend CoroutineScope.() -> Unit
    ): Job {
        return (scope + CoroutineExceptionHandler { _, _ -> }).launch(context = Dispatchers.IO) {
            runCatching { block() }
                .exceptionOrNull()
                ?.let { Log.d("launch exception", it.message.toString()) }
        }
    }
}