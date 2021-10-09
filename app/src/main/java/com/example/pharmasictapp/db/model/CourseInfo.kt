package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class CourseInfo(
    @SerializedName("UserId")
    val userId:String,
    @SerializedName("CourseId")
    val courseId:Int
    )
