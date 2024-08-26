package com.example.yandexcartapp.uikit.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

interface AppColors {
    val white: Color
    val black: Color
    val yellow: Color


}


class AppColorsLight(
    override val white: Color,
    override val black: Color,
    override val yellow: Color,


    ) : AppColors

fun appLightColors() = AppColorsLight(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF0C0C0C),
    yellow = Color(0xFFFFCC00),

    )


fun appDarkColors() = AppColorsLight(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF0C0C0C),
    yellow = Color(0xFFFFCC00),

    )


val LocalColors = compositionLocalOf<AppColors> {
    error(
        "No colors provided! Make sure to wrap all usages of components in a " +
                "AppTheme."
    )
}
