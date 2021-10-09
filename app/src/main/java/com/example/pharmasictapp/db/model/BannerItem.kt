package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class BannerItem(
    val id:Int,
    @SerializedName("name")
    val imageName:String,
    @SerializedName("image_path")
    val imageUrl:String,
    val route:String,
    val rank:Int,


    )
