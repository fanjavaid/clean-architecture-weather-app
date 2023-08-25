package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city

import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated.CityDetailNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import javax.inject.Inject

class CityDetailMapper @Inject constructor() : BaseDomainMapper<CityDetailNetworkResponse, CityDetail> {
    override fun mapToDomainModel(data: CityDetailNetworkResponse): CityDetail {
        return CityDetail(
            name = data.name,
            latitude = data.location.latlon.latitude,
            longitude = data.location.latlon.longitude
        )
    }
}
