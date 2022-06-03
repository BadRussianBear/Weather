package com.example.weather.features.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentation.features.weatherList.LatestWeatherUiState
import com.example.presentation.features.weatherList.WeatherListNavigation
import com.example.presentation.features.weatherList.WeatherListViewModel
import com.example.weather.R
import com.example.weather.base.BaseFragment
import com.example.weather.databinding.FragmentWeatherListBinding
import com.example.weather.extensions.Screens
import com.example.weather.extensions.viewComponent
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class WeatherListFragment : BaseFragment() {

    private var _binding: FragmentWeatherListBinding? = null
    private val binding get() = checkNotNull(_binding)
    private var weatherListAdapter: WeatherListAdapter? = null

    private val viewModel by viewModels<WeatherListViewModel> { viewModelFactory }

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewComponent().inject(this)
        bindToLifecycle(viewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        registerFlows()
        registerNavigation()
        viewModel.getCity()
        viewModel.getList()
    }

    private fun setUpRecyclerView() {
        weatherListAdapter = WeatherListAdapter(
            articleOnClick = { item -> viewModel.dayClicked(item) }
        )

        binding.recyclerViewWeatherList.adapter = weatherListAdapter
    }

    private fun registerNavigation() {
        viewModel.eventsFlow.onEach {
            when (it) {
                is WeatherListNavigation.OpenDetailView -> {
                    router.navigateTo(Screens.WeatherDetails(it.id))
                }
                is WeatherListNavigation.OpenSettings -> {
                    router.navigateTo(Screens.Settings())
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun registerFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.weatherUIState.collect {
                when (it) {
                    is LatestWeatherUiState.Loading -> {
                        with(binding) {
                            error.text = "Loading"
                            error.isVisible = true
                            binding.recyclerViewWeatherList.isVisible = false
                        }
                    }
                    is LatestWeatherUiState.Success -> {
                        with(binding) {
                            error.isVisible = false
                            binding.recyclerViewWeatherList.isVisible = true
                        }
                        weatherListAdapter?.submitList(it.info)
                    }
                    is LatestWeatherUiState.Error -> {
                        with(binding) {
                            error.text = it.message
                            error.isVisible = true
                            binding.recyclerViewWeatherList.isVisible = false
                        }
                    }
                }
            }
        }

        viewModel.cityFlow.onEach {
            binding.city.text = it
        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                viewModel.settingsClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.recyclerViewWeatherList.adapter = null
        _binding = null
    }
}