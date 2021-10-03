package com.example.pharmasictapp.db.model

class Instructor
{

     private var name:String?=null
    private var description:String?=null

    fun setName(instructor_name:String){
        name=instructor_name
    }


    fun setDescription(instructor_description:String){

        description=instructor_description
    }

    fun getName():String
    {
        return name?:"Noura"
    }

    fun getDescription():String
    {
        return description?:"Software Engineer at x company."

    }
}