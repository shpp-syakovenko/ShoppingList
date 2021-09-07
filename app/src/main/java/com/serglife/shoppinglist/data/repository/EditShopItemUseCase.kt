package com.serglife.shoppinglist.data.repository

import com.serglife.shoppinglist.data.entity.ShopItem

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}