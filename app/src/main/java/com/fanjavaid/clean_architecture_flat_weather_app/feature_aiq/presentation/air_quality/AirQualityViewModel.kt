package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.air_quality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.air_quality.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.usecases.GetAirQualityIndex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AirQualityViewModel @Inject constructor(
    private val getAirQualityIndex: GetAirQualityIndex
) : ViewModel() {

    private var _airQualityIndexState = MutableStateFlow(AirQualityIndexUiState())
    val airQualityIndexState = _airQualityIndexState.asStateFlow()

    fun getAirQualityIndex() = viewModelScope.launch {
        val aqi = getAirQualityIndex.invoke(54.2001491,-116.7339768)
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
