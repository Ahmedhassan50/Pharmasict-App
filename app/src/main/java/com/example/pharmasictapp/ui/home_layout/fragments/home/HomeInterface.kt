package com.example.pharmasictapp.ui.home_layout.fragments.home

import com.example.pharmasictapp.db.model.Event
import com.example.pharmasictapp.db.model.Offer
import com.example.pharmasictapp.utils.GET_EVENTS
import com.example.pharmasictapp.utils.GET_OFFERS
import retrofit2.Response
import retrofit2.http.GET

interface HomeInterface {

    @GET(GET_EVENTS)
    suspend fun getEvents():Response<List<Event>>

    @GET(GET_OFFERS)
    suspend fun getOffers():Response<List<Offer>>

}