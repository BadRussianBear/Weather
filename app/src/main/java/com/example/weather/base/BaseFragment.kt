package com.example.weather.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.presentation.base.BaseViewModel
import com.example.weather.di.factory.ViewModelFactory
import com.example.weather.extensions.viewComponent
import javax.inject.Inject

abstract class BaseFragment : Fragment, BaseView {

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val delegate = BaseViewDelegate()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewComponent().inject(this)
    }

    internal fun bindToLifecycle(viewModel: BaseViewModel) {
        delegate.bindViewModelToLifecycle(this, viewModel)
    }
}