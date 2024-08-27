package com.example.yandexcartapp.data.model

data class CartItemResponse(
    val id: String?,
    val name: String?,
    val count: Int?,
    val price: Int?,
    val currency: String?,
    val imageUrl: String?,
) {
}