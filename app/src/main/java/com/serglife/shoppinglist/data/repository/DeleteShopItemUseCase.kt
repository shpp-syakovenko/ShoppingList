package com.serglife.shoppinglist.data.repository

import com.serglife.shoppinglist.data.entity.ShopItem

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}