package com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper

/**
 * T = Input
 * R = Result which is Domain model
 */
interface BaseDomainMapper<T, R> {

    fun mapToDomainModel(data: T): R
}
