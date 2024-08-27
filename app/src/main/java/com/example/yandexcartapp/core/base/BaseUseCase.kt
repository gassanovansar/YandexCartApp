package com.example.yandexcartapp.core.base

abstract class BaseUseCase<in Params, out Type : Any> {
    abstract suspend fun execute(params: Params): Type

    open suspend operator fun invoke(params: Params): Type {
        return execute(params)
    }
}