package com.example.yandexcartapp.domain.useCase

import com.example.yandexcartapp.core.base.BaseUseCase
import com.example.yandexcartapp.domain.repository.CartInteractor

class DeleteCartUseCase(private val repository: CartInteractor) :
    BaseUseCase<DeleteCartUseCase.Params, Unit>() {

    class Params

    override suspend fun execute(params: Params) {
        return repository.deleteCart()
    }
}