package com.example.yandexcartapp.data.localSource

import com.example.yandexcartapp.data.model.CartItemResponse
import com.example.yandexcartapp.domain.model.CartItem

class LocalSource() {

    var date: List<CartItemResponse> = listOf(
        CartItemResponse(
            id = "1",
            name = "Суп Том Ям с морепродуктами",
            count = 1,
            price = 100,
            currency = "₽",
            imageUrl = "https://menunedeli.ru/wp-content/uploads/2020/04/Kuriniy-sup-za-15-minut-500x350-1200x840.jpg"
        ), CartItemResponse(
            id = "2",
            name = "Поке с индейкой и чуккой",
            count = 1,
            price = 100,
            currency = "₽",
            imageUrl = "https://menunedeli.ru/wp-content/uploads/2020/04/Kuriniy-sup-za-15-minut-500x350-1200x840.jpg"
        ), CartItemResponse(
            id = "3",
            name = "Поке с тунцом, лососем, авокадо",
            count = 1,
            price = 100,
            currency = "₽",
            imageUrl = "https://menunedeli.ru/wp-content/uploads/2020/04/Kuriniy-sup-za-15-minut-500x350-1200x840.jpg"
        ), CartItemResponse(
            id = "4",
            name = "Блинчики с малиной и маскарпоне",
            count = 1,
            price = 100,
            currency = "₽",
            imageUrl = "https://menunedeli.ru/wp-content/uploads/2020/04/Kuriniy-sup-za-15-minut-500x350-1200x840.jpg"
        )
    )

    /**
     * Возвращает список всех элементов в корзине
     */
    fun getCartItems(): List<CartItemResponse> {
        return date
    }

    /**
     * Удаляет корзину
     */
    fun deleteCart() {
        date = emptyList()
    }

    /**
     * Обновляет элемент корзины
     */
    fun updateCartItem(item: CartItem) {
        date = date.map {
            if (it.id == item.id) {
                if (item.count == 0 || item.count == 100) {
                    it
                } else {
                    it.copy(count = item.count)
                }
            } else {
                it
            }
        }.filter { (it.count ?: 0) > 0 }
    }

    /**
     * Обновляет элементы корзины
     */
    fun updateCartItem(items: List<CartItem>) {

    }

}