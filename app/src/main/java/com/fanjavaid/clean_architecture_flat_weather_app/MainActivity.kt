package com.fanjavaid.clean_architecture_flat_weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.AirQualityScreen
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.HomeScreen
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

sealed class AppScreen(val route: String, val icon: ImageVector) {
    object Weather : AppScreen("weather", Icons.Default.Home)
    object AirQuality : AppScreen("air-quality", Icons.Default.Air)
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    tonalElevation = 2.dp
                ) {
                    App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()
    val screens = listOf(
        AppScreen.Weather,
        AppScreen.AirQuality,
    )

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                tonalElevation = 6.dp
            ) {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination
                            ?.hierarchy
                            ?.any { it.route == screen.route } == true,
                        onClick = {
                            navHostController.navigate(screen.route) {
                                popUpTo(navHostController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                screen.icon,
                                contentDescription = screen.route
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navHostController,
            startDestination = AppScreen.Weather.route
        ) {
            composable(AppScreen.Weather.route) {
                HomeScreen()
            }
            composable(AppScreen.AirQuality.route) {
                AirQualityScreen()
            }
        }
    }
}
