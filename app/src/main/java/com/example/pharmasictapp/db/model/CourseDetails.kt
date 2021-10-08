package com.example.pharmasictapp.db.model

data class CourseDetails (
    val courseId:String,
    val title:String,
    val description:String,
    val startDate:String,
    val endDate:String,
    val objective:String,
    val courseTypeId:Int,
    val courseTypeName:String,
    val lectures:List<Lecture>,
    val instructors:List<Instructor>
    )

data class Lecture(val lec:String)

data class Instructor(val ins:String)