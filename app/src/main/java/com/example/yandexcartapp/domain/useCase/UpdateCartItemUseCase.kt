package com.example.yandexcartapp.domain.useCase

import com.example.yandexcartapp.core.base.BaseUseCase
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.domain.repository.CartInteractor

class UpdateCartItemUseCase(private val repository: CartInteractor) :
    BaseUseCase<UpdateCartItemUseCase.Params, Unit>() {
    class Params(val item: CartItem)

    override suspend fun execute(params: Params) {
        return repository.updateCartItem(params.item)
    }
}