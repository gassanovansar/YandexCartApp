package com.example.yandexcartapp.uikit.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

interface AppColors {
    val white: Color
    val black: Color
    val black1: Color
    val yellow: Color
    val gray: Color
    val gray1: Color
    val gray2: Color


}


class AppColorsLight(
    override val white: Color,
    override val black: Color,
    override val black1: Color,
    override val yellow: Color,
    override val gray: Color,
    override val gray1: Color,
    override val gray2: Color,


    ) : AppColors

fun appLightColors() = AppColorsLight(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF21201F),
    black1 = Color(0xFF21201F),
    yellow = Color(0xFFFCE000),
    gray = Color(0xFFF5F4F2),
    gray1 = Color(0xFF9D9B98),
    gray2 = Color(0xFFDBDBDA),
)


fun appDarkColors() = AppColorsLight(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF21201F),
    black1 = Color(0xFF21201F),
    yellow = Color(0xFFFCE000),
    gray = Color(0xFFF5F4F2),
    gray1 = Color(0xFF9D9B98),
    gray2 = Color(0xFFDBDBDA),
)


val LocalColors = compositionLocalOf<AppColors> {
    error(
        "No colors provided! Make sure to wrap all usages of components in a " +
                "AppTheme."
    )
}
