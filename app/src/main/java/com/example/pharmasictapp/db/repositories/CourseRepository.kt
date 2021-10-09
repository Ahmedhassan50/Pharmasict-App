package com.example.pharmasictapp.db.repositories

import android.util.Log
import com.example.pharmasictapp.db.model.*
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CoursesInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class CourseRepository(private val api:CoursesInterface) {

    suspend fun getUpComingCourses()= withContext(Dispatchers.IO){
        api.getUpComingCourses()
    }

    suspend fun getCourseDetails(id:Int)= withContext(Dispatchers.IO){
        api.getCourseDetails(id)
    }

    suspend fun courseRegister(userId:String,courseId:Int)= withContext(Dispatchers.IO){
      //  val courseInfo:Map<String,Any> = mapOf("UserId" to userId ,"CourseId" to courseId )
        api.courseRegister(CourseInfo(userId,courseId))
    }

    suspend fun sendEmail(email:String,courseName:String)= withContext(Dispatchers.IO){
        val emailInfo=SendEmail(
            personalizations = listOf(Personalizations(to = listOf(To(email)))),
            from = From("ahmed.code5066@gmail.com"),
            subject = "Pharmacist App Courses",
            content = listOf(Content(type = "text/plain",
                value = "congratulations you have registered in course $courseName"))

        )
        api.sendEmail(emailInfo)
    }


    suspend fun getMyCourses(userId:String)= withContext(Dispatchers.IO){
        api.getMyCourses(userId)
    }
}