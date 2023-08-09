package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.util

import java.text.SimpleDateFormat
import java.util.Date

fun Date.formatSlashShort(): String? = SimpleDateFormat("dd/MM/yyyy").format(this)

fun Date.formatThreeCharsDay(): String? = SimpleDateFormat("EEE").format(this)