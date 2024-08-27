package com.example.yandexcartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.yandexcartapp.feature.cart.CartScreen
import com.example.yandexcartapp.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                CartScreen()
            }
        }
    }
}