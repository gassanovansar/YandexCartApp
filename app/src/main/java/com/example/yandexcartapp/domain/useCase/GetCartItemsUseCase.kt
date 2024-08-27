package com.example.yandexcartapp.domain.useCase

import com.example.yandexcartapp.core.base.BaseUseCase
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.domain.repository.CartInteractor

class GetCartItemsUseCase(private val repository: CartInteractor) :
    BaseUseCase<GetCartItemsUseCase.Params, List<CartItem>>() {
    class Params

    override suspend fun execute(params: Params): List<CartItem> {
        return repository.getCartItems()
    }
}