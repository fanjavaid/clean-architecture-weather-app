package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.usecases.GetAirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.shared.domain.GetLastSavedCity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AirQualityViewModel @Inject constructor(
    private val getAirQualityIndex: GetAirQualityIndex,
    private val getLastSavedCity: GetLastSavedCity
) : ViewModel() {

    private var _airQualityIndexState = MutableStateFlow(AirQualityIndexUiState())
    val airQualityIndexState = _airQualityIndexState.asStateFlow()

    init {
        viewModelScope.launch {
            getLastSavedCity.invoke().collectLatest {
                getAirQualityIndex(latitude = it.latitude, longitude = it.longitude)
            }
        }
    }

    private fun getAirQualityIndex(
        latitude: Double,
        longitude: Double
    ) = viewModelScope.launch {
        val aqi = getAirQualityIndex.invoke(latitude, longitude)
        _airQualityIndexState.update { currentState ->
            currentState.copy(
                data = aqi
            )
        }
    }

    data class AirQualityIndexUiState(
        val data: AirQualityIndex? = null,
        val loading: Boolean = false
    )
}
