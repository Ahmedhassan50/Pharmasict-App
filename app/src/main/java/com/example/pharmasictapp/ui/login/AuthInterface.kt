package com.example.pharmasictapp.ui.login

import com.example.pharmasictapp.utils.LOGIN_ENDPOINT
import com.google.gson.JsonObject

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthInterface {


    @POST(LOGIN_ENDPOINT)
    suspend fun login(
        @Body userCredential:Map<String,String>): Response<JsonObject>

}