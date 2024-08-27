package com.example.yandexcartapp.data

import com.example.yandexcartapp.data.localSource.LocalSource
import com.example.yandexcartapp.data.mapper.toUI
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.domain.repository.CartInteractor

class CartInteractorImpl(private val localSource: LocalSource) : CartInteractor {
    override suspend fun getCartItems(): List<CartItem> {
        return localSource.getCartItems().map {
            it.toUI()
        }
    }

    override suspend fun deleteCart() {
        localSource.deleteCart()
    }

    override suspend fun updateCartItem(item: CartItem) {
        localSource.updateCartItem(item)
    }

    override suspend fun updateCartItem(items: List<CartItem>) {

    }
}