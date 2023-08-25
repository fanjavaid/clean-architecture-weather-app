package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.CloudsNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.core.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Clouds
import javax.inject.Inject

class CloudsMapper @Inject constructor() : BaseDomainMapper<CloudsNetworkResponse, Clouds> {
    override fun mapToDomainModel(data: CloudsNetworkResponse): Clouds {
        return Clouds(all = data.all)
    }
}
