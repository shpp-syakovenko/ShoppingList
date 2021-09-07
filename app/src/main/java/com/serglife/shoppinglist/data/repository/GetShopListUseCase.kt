package com.serglife.shoppinglist.data.repository

import androidx.lifecycle.LiveData
import com.serglife.shoppinglist.data.entity.ShopItem

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}