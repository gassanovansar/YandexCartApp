package com.example.yandexcartapp.data.mapper

import com.example.yandexcartapp.data.model.CartItemResponse
import com.example.yandexcartapp.domain.model.CartItem

fun CartItemResponse.toUI(): CartItem {
    return CartItem(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        count = this.count ?: 0,
        price = this.price ?: 0,
        currency = this.currency.orEmpty(),
        imageUrl = this.imageUrl.orEmpty()
    )
}