package com.example.jobfinder.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Blue_theme_dark,
    onPrimary = White_theme_dark,
    primaryContainer  = DarkBlue_theme_dark,
    secondary = Green_theme_dark,
    onSecondary = Grey1_theme_dark,
    secondaryContainer  = DarkGreen_theme_dark,
    background = Black_theme_dark,
    surface = Grey2_theme_dark,
    onBackground = Grey5_theme_dark,
    onSurface = Grey4_theme_dark,
    error = Red_theme_dark,
    tertiary = Grey3_theme_dark
)

private val LightColorScheme = lightColorScheme(
    primary = Blue_theme_light,
    onPrimary = White_theme_light,
    primaryContainer  = DarkBlue_theme_light,
    secondary = Green_theme_light ,
    onSecondary = Grey1_theme_light,
    secondaryContainer  = DarkGreen_theme_light,
    background = Black_theme_light,
    surface = Grey2_theme_light,
    onBackground = Grey5_theme_light,
    onSurface = Grey4_theme_light,
    error = Red_theme_light,
    tertiary = Grey3_theme_light
)

@Composable
fun JobFinderTheme(
    darkTheme: Boolean = true,//isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}