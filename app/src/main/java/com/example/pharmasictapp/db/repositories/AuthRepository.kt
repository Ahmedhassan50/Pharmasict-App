package com.example.pharmasictapp.db.repositories

import android.util.Log
import com.example.pharmasictapp.ui.login.AuthInterface
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthRepository(private val api: AuthInterface) {


    suspend fun login(email:String,password:String)= withContext(Dispatchers.IO){
         api.login(mapOf("email" to email ,"password" to password))
     }



}