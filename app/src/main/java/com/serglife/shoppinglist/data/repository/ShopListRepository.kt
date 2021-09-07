package com.serglife.shoppinglist.data.repository

import androidx.lifecycle.LiveData
import com.serglife.shoppinglist.data.entity.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItem: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}