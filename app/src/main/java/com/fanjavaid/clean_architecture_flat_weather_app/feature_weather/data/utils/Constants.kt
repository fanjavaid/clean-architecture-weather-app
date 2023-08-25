package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.utils

import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    val cityName = stringPreferencesKey("city_name")
    val latPrefKey = doublePreferencesKey("latitude")
    val lonPrefKey = doublePreferencesKey("longitude")
}
