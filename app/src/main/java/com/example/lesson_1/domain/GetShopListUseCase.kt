package com.example.lesson_1.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase (private val shopListRepository: ShopListRepository){

    fun getShopList(): LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }

}