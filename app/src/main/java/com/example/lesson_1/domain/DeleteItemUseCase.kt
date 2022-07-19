package com.example.lesson_1.domain

class DeleteItemUseCase(private val shopListRepository: ShopListRepository){
    fun deleteShopItem(shopItem :ShopItem){
        shopListRepository.deleteShopItem(shopItem)

    }
}