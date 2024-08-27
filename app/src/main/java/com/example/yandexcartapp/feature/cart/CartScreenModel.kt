package com.example.yandexcartapp.feature.cart

import com.example.yandexcartapp.core.base.BaseScreenModel
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.domain.useCase.DeleteCartUseCase
import com.example.yandexcartapp.domain.useCase.GetCartItemsUseCase
import com.example.yandexcartapp.domain.useCase.UpdateCartItemUseCase
import org.koin.core.component.inject

class CartScreenModel : BaseScreenModel<CartState, Any>(CartState.Default) {

    private val getCartItemsUseCase: GetCartItemsUseCase by inject()
    private val deleteCartUseCase: DeleteCartUseCase by inject()
    private val updateCartItemUseCase: UpdateCartItemUseCase by inject()

    fun getCartItem() {
        launchOperation(operation = {
            getCartItemsUseCase(GetCartItemsUseCase.Params())
        }, success = {
            setState { state.value.copy(carts = it) }
        })
    }

    fun deleteCart() {
        launchOperation(operation = {
            deleteCartUseCase(DeleteCartUseCase.Params())
        }, success = {
            getCartItem()
        })
    }

    fun increase(item: CartItem) {
        launchOperation(operation = {
            updateCartItemUseCase(UpdateCartItemUseCase.Params(item.copy(count = item.count + 1)))
        }, success = {
            getCartItem()
        })
    }

    fun decrease(item: CartItem) {
        launchOperation(operation = {
            updateCartItemUseCase(UpdateCartItemUseCase.Params(item.copy(count = item.count - 1)))
        }, success = {
            getCartItem()
        })
    }


}