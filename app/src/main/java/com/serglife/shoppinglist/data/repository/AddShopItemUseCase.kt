package com.serglife.shoppinglist.data.repository

import com.serglife.shoppinglist.data.entity.ShopItem

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}