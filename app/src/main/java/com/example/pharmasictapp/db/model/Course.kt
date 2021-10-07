package com.example.pharmasictapp.db.model

data class Course(


    val courseId:Int,
    val title:String,
    val description:String,
    val startDate:String,
    val endDate:String,
    val courseTypeName:String,
    val courseTypeId:Int,


) {
    private var name:String?=null
    private var type:String?=null
    private var objective:String?=null



    fun setName(course_name:String){
        name=course_name
    }
    fun setType(course_type:String){
        name=course_type
    }
    fun setObjective(course_objective:String){
        name=course_objective
    }
    fun getName():String
    {
        return name?:"Python Master Class"
    }

    fun getType():String
    {
        return type?:"Virtual"

    }
    fun getObjective():String
    {
        return objective?:"Data enthusiasts who are targeting Data Science as a career choice"

    }


}