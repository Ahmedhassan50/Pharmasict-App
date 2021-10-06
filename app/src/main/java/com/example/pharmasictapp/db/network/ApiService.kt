package com.example.pharmasictapp.db.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object{
       private const val BASE_URL:String ="http://pharmacist-001-site1.htempurl.com/Api/"
        fun getRetrofitBuilder(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }






}