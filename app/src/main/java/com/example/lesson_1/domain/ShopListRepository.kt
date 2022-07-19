package com.example.lesson_1.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem :ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId:Int): ShopItem

    fun getSopList(): List<ShopItem>

}