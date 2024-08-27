package com.example.yandexcartapp.domain.useCase

import com.example.yandexcartapp.core.base.BaseUseCase
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.domain.repository.CartInteractor

class UpdateCartItemsUseCase(private val repository: CartInteractor) :
    BaseUseCase<UpdateCartItemsUseCase.Params, Unit>() {
    class Params(val items: List<CartItem>)

    override suspend fun execute(params: Params) {
        return repository.updateCartItem(params.items)
    }
}