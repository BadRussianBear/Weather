package com.example.weather.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.presentation.base.BaseViewModel
import com.example.weather.di.factory.ViewModelFactory
import com.example.weather.extensions.viewComponent
import javax.inject.Inject

abstract class BaseActivity : FragmentActivity, BaseView {

    private val delegate = BaseViewDelegate()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewComponent().inject(this)
    }

    internal fun bindToLifecycle(viewModel: BaseViewModel) {
        delegate.bindViewModelToLifecycle(this, viewModel)
    }
}