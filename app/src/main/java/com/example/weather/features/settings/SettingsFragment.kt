package com.example.weather.features.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentation.features.settings.SettingsNavigation
import com.example.presentation.features.settings.SettingsViewModel
import com.example.weather.base.BaseFragment
import com.example.weather.databinding.FragmentSettingsBinding
import com.example.weather.extensions.Screens
import com.example.weather.extensions.viewComponent
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class SettingsFragment : BaseFragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = checkNotNull(_binding)
    private var cityListAdapter: CityListAdapter? = null

    private val viewModel by viewModels<SettingsViewModel> { viewModelFactory }

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewComponent().inject(this)
        bindToLifecycle(viewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setUiEvents()
        setUpRecyclerView()
        registerNavigation()
        registerFlows()
        viewModel.getCityList()
        viewModel.getUnit()
    }

    private fun setUiEvents() {
        with(binding) {
            tvCurrentCity.setOnClickListener {
                rvCities.isVisible = true
                bDivination.isVisible = false
            }
            swUnit.setOnCheckedChangeListener { view, isChecked ->
                if(view.isPressed)
                    viewModel.unitChanged()
            }
            bDivination.setOnClickListener {
                viewModel.divinationClicked()
            }
        }
    }

    private fun setUpRecyclerView() {
        cityListAdapter = CityListAdapter (
            articleOnClick = { item -> viewModel.cityClicked(item) }
        )
        binding.rvCities.adapter = cityListAdapter
    }

    private fun registerNavigation() {
        viewModel.eventsFlow.onEach {
            when (it) {
                is SettingsNavigation.OpenWebPage -> {
                    router.navigateTo(Screens.Github())
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun registerFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.cityUIState.collect {
                with(binding) {
                    binding.rvCities.isVisible = false
                    bDivination.isVisible = true
                    binding.tvCurrentCity.text = it.find { city -> city.isSelected }?.name
                }
                cityListAdapter?.submitList(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.unitUIState.collect {
                binding.swUnit.isChecked = it
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.rvCities.adapter = null
        _binding = null
    }
}