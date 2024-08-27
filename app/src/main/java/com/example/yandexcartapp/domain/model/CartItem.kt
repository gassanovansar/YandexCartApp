package com.example.yandexcartapp.domain.model

data class CartItem(
    val id: String,
    val name: String,
    val count: Int,
    val price: Int,
    val currency: String,
    val imageUrl: String,
)