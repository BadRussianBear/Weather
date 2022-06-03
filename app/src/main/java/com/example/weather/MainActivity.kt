package com.example.weather

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.data.AppDatabase
import com.example.presentation.features.LatestMainUiState
import com.example.presentation.features.MainViewModel
import com.example.presentation.features.weatherList.LatestWeatherUiState
import com.example.weather.base.BaseActivity
import com.example.weather.databinding.MainActivityBinding
import com.example.weather.extensions.Screens.WeatherList
import com.example.weather.extensions.viewComponent
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject
import kotlinx.coroutines.flow.collect


class MainActivity : BaseActivity() {

    @Inject
    lateinit var db: AppDatabase

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = object : AppNavigator(this, R.id.container) {

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }
    private var _binding: MainActivityBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = binding.toolbar
        setActionBar(toolbar)
        viewComponent().inject(this)
        bindToLifecycle(viewModel)
        registerFlows()
        viewModel.startInit()
    //        Log.d("DATABASE", db.openHelper.databaseName.toString())
    }

    private fun registerFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.mainUIState.collect {
                when (it) {
                    is LatestMainUiState.Loading -> {
                        with(binding) {
                            tvStatus.isVisible = true
                            container.isVisible = false
                            tvStatus.text = "Initializing"
                        }
                    }
                    is LatestMainUiState.Success -> {
                        with(binding) {
                            tvStatus.isVisible = false
                            container.isVisible = true
                        }
                        navigator.applyCommands(arrayOf<Command>(Replace(WeatherList())))
                    }
                    is LatestMainUiState.Error -> {
                        with(binding) {
                            tvStatus.isVisible = false
                            container.isVisible = true
                            tvStatus.text = it.message
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(applicationContext)
        inflater.inflate(R.menu.bar_menu, menu)
        return true
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}