package com.example.yandexcartapp.di

import com.example.yandexcartapp.domain.useCase.DeleteCartUseCase
import com.example.yandexcartapp.domain.useCase.GetCartItemsUseCase
import com.example.yandexcartapp.domain.useCase.UpdateCartItemUseCase
import com.example.yandexcartapp.domain.useCase.UpdateCartItemsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory<DeleteCartUseCase> { DeleteCartUseCase(get()) }
    factory<GetCartItemsUseCase> { GetCartItemsUseCase(get()) }
    factory<UpdateCartItemsUseCase> { UpdateCartItemsUseCase(get()) }
    factory<UpdateCartItemUseCase> { UpdateCartItemUseCase(get()) }
}