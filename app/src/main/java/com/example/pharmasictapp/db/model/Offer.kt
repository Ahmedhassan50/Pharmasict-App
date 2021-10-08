package com.example.pharmasictapp.db.model

data class Offer(
    val id:Int,
    val offerName:String,
    val productName:String,
    val offerDescription:String,
    val offerConditions:String,
    val imgName:String,
    val imgPath:String,
    val rank:Int,
    val startDate:String,
    val photoUrl:String,
    val endDate:String
)
