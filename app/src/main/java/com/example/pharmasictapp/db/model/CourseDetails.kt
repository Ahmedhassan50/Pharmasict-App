package com.example.pharmasictapp.db.model

import com.google.gson.annotations.SerializedName

data class CourseDetails (
    val courseId:String,
    val title:String,
    val description:String,
    val startDate:String,
    val imgPath:String,
    val endDate:String,
    val objective:String,
    val courseTypeId:Int,
    val courseTypeName:String,
    @SerializedName("lectures")
    val lectures:List<Lecture>,
    val instructors:List<Instructor>
    )

data class Lecture(
    val lectureId:Int,
    val lectureName:String,
    val courseId:String,

    )

data class Instructor(
    val id:Int,
    val name:String,
    val about:String

    )