package com.example.weather.base

import androidx.lifecycle.LifecycleOwner
import com.example.presentation.base.BaseViewModel

interface BaseView : LifecycleOwner

class BaseViewDelegate {

    fun bindViewModelToLifecycle(baseView: BaseView, viewModel: BaseViewModel) {
        baseView.lifecycle.addObserver(viewModel)
    }
}