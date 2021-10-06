package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id")
    val id:String,
    val email:String,
    val name:String,
    @SerializedName("image")
    val imageURL:String,
    @SerializedName("phone")
    val phoneNumber:String,
    val token:String,

)
