package com.example.yandexcartapp.feature.cart

import com.example.yandexcartapp.domain.model.CartItem

data class CartState(
    val carts: List<CartItem>
) {

    val allPrice = carts.sumOf { it.price*it.count }

    companion object {
        val Default = CartState(carts = emptyList())
    }
}