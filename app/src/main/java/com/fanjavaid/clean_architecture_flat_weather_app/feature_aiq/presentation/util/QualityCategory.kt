package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.util

import androidx.compose.ui.graphics.Color
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.AirQualityIndexColorScheme
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_DangerDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_ErrorColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_SuccessColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_WarningColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_WarningDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onDangerDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onErrorColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onSuccessColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onWarningColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onWarningDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_DangerDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_ErrorColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_SuccessColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_WarningColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_WarningDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_onDangerDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_onErrorColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_onSuccessColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_onWarningColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.light_onWarningDarkerColor

fun getQualityIndexInformation(index: Int, isDarkMode: Boolean = false): AirQualityIndexColorScheme {
    return when {
        index in 0..50 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_SuccessColor else light_SuccessColor,
            if (isDarkMode) dark_onSuccessColor else light_onSuccessColor,
            "Good",
            "Air quality is considered satisfactory, and air pollution poses little or no risk"
        )

        index in 51..100 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_WarningColor else light_WarningColor,
            if (isDarkMode) dark_onWarningColor else light_onWarningColor,
            "Moderate",
            "Air quality is acceptable; however, for some pollutants there may be a moderate health concern for a " +
                "very small number of people who are unusually sensitive to air pollution."
        )

        index in 101..150 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_WarningDarkerColor else light_WarningDarkerColor,
            if (isDarkMode) dark_onWarningColor else light_onWarningColor,
            "Unhealthy",
            "Members of sensitive groups may experience health effects. " +
                "The general public is not likely to be affected."
        )

        index in 151..200 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_WarningDarkerColor else light_WarningDarkerColor,
            if (isDarkMode) dark_onWarningDarkerColor else light_onWarningDarkerColor,
            "Unhealthy",
            "Everyone may begin to experience health effects; members of sensitive groups may experience " +
                "more serious health effects"
        )

        index in 201..300 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_ErrorColor else light_ErrorColor,
            if (isDarkMode) dark_onErrorColor else light_onErrorColor,
            "Very Unhealthy",
            "Health warnings of emergency conditions. The entire population is more likely to be affected."
        )

        index > 300 -> AirQualityIndexColorScheme(
            if (isDarkMode) dark_DangerDarkerColor else light_DangerDarkerColor,
            if (isDarkMode) dark_onDangerDarkerColor else light_onDangerDarkerColor,
            "Hazardous",
            "Health alert: everyone may experience more serious health effects"
        )

        else -> AirQualityIndexColorScheme(
            Color.Transparent,
            Color.Transparent,
            "Unknown",
            "None"
        )
    }
}
