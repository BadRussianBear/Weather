package com.example.weather.features.weather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentation.features.weatherDetails.LatestDetailsUiState
import com.example.presentation.features.weatherDetails.WeatherDetailsViewModel
import com.example.presentation.features.weatherDetails.WeatherLocalItem
import com.example.presentation.features.weatherList.WeatherListNavigation
import com.example.weather.R
import com.example.weather.base.BaseFragment
import com.example.weather.databinding.FragmentWeatherDetailsBinding
import com.example.weather.extensions.Screens
import com.example.weather.extensions.viewComponent
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class WeatherDetailsFragment : BaseFragment() {

    private var _binding: FragmentWeatherDetailsBinding? = null
    private val binding get() = checkNotNull(_binding)

    private val viewModel by viewModels<WeatherDetailsViewModel> { viewModelFactory }

    private val weatherKey: Long
        get() = requireArguments().getLong(WEATHER_KEY)

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
        _binding = FragmentWeatherDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerNavigation()
        registerFlows()
        viewModel.getDetails(weatherKey)
    }

    private fun registerNavigation() {
        viewModel.eventsFlow.onEach {
            when (it) {
                is WeatherListNavigation.OpenSettings -> {
                    router.navigateTo(Screens.Settings())
                }
                else -> Unit
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun registerFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.weatherUIState.collect {
                when (it) {
                    is LatestDetailsUiState.Loading -> {

                    }
                    is LatestDetailsUiState.Success -> {
                        fillView(it.info)
                    }
                }
            }
        }
    }

    private fun fillView(info: WeatherLocalItem) = with(binding) {
        with(dayContainer) {
            tvDay.text = "Day"
            ivDay.setImageDrawable(ResourcesCompat.getDrawable(resources, info.dayIcon, null))
            tvTemp.text = info.max
            tvRealTempValue.text = info.dayRealFeel.toString()
            tvRealTempDesc.text = info.dayRealFeelPhrase
            tvDescription.text = info.dayLongPhrase
            tvWindValue.text = info.dayWindSpeed.toString()
            tvWindGustsValue.text = info.dayWindGusts.toString()
            tvThunderValue.text = info.dayThunderstormProbability.toString()
            tvCloudCoverValue.text = info.dayCloudCover.toString()
        }
        with(nightContainer) {
            tvDay.text = "Night"
            ivDay.setImageDrawable(ResourcesCompat.getDrawable(resources, info.nightIcon, null))
            tvTemp.text = info.min
            tvRealTempValue.text = info.nightRealFeel.toString()
            tvRealTempDesc.text = info.nightRealFeelPhrase
            tvDescription.text = info.nightLongPhrase
            tvWindValue.text = info.nightWindSpeed.toString()
            tvWindGustsValue.text = info.nightWindGusts.toString()
            tvThunderValue.text = info.nightThunderstormProbability.toString()
            tvCloudCoverValue.text = info.nightCloudCover.toString()
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
    }

    companion object {
        private const val WEATHER_KEY = "weather_key"
        fun getNewInstance(id: Long): WeatherDetailsFragment {
            return WeatherDetailsFragment().apply {
                arguments = Bundle().apply {
                    putLong(WEATHER_KEY, id)
                }
            }
        }
    }

}