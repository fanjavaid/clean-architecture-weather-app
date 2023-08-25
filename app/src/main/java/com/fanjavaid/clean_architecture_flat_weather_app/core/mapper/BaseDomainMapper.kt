package com.fanjavaid.clean_architecture_flat_weather_app.core.mapper

/**
 * T = Input
 * R = Result which is Domain model
 */
interface BaseDomainMapper<T, R> {

    fun mapToDomainModel(data: T): R
}
