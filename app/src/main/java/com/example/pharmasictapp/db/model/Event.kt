package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class Event(
    val id:Int,
    val name:String,
    val date:String,
    @SerializedName("type_name")
    val type:String,
    @SerializedName("type_id")
    val typeId:String
)
