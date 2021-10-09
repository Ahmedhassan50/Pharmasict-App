package com.example.pharmasictapp.ui.home_layout.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmasictapp.db.model.BannerItem
import com.example.pharmasictapp.db.model.Event
import com.example.pharmasictapp.db.model.HomeData
import com.example.pharmasictapp.db.model.Offer
import com.example.pharmasictapp.db.network.ApiService
import com.example.pharmasictapp.db.repositories.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    private var homeRepository:HomeRepository

   private var homeMutableLiveData =MutableLiveData<HomeData?>()
    val homeLiveData:LiveData<HomeData?> get() = homeMutableLiveData

    init {
        val serviceInstance=ApiService.getRetrofitBuilder().create(HomeInterface::class.java)
        homeRepository= HomeRepository(serviceInstance)

    }

    fun clearData(){
        homeMutableLiveData.postValue(null)

    }


    fun getHomeData()=viewModelScope.launch {
       val eventResult= homeRepository.getEvents()
        var loadedEvents:List<Event> = emptyList()

        if (eventResult.isSuccessful){
            if (eventResult.body() !=null){
                loadedEvents =eventResult.body() as List<Event>
            }
        }

        val offerResult= homeRepository.getOffers()
        var loadedOffers:List<Offer> = emptyList()

        if (offerResult.isSuccessful){
            if (offerResult.body() !=null){
                loadedOffers =offerResult.body() as List<Offer>
            }
        }

        val bannerResult=homeRepository.getBanners()
        var loadedBanners:List<BannerItem> = emptyList()
        if(bannerResult.isSuccessful){
            if(bannerResult.body()!=null){
                loadedBanners= bannerResult.body() as List<BannerItem>
            }
        }


        homeMutableLiveData.postValue(HomeData(loadedBanners,loadedEvents,loadedOffers))
    }


}