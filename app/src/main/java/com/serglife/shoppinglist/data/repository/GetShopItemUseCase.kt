package com.serglife.shoppinglist.data.repository

import com.serglife.shoppinglist.data.entity.ShopItem

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItem: Int): ShopItem{
        return shopListRepository.getShopItem(shopItem)
    }
}