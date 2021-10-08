package com.example.pharmasictapp.db.repositories

import com.example.pharmasictapp.ui.home_layout.fragments.home.HomeInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(private val api:HomeInterface) {
    suspend fun getBanners()= withContext(Dispatchers.IO){
        api.getBanners()
    }

    suspend fun getEvents()= withContext(Dispatchers.IO){
        api.getEvents()
    }
    suspend fun getOffers()= withContext(Dispatchers.IO){
        api.getOffers()
    }
}