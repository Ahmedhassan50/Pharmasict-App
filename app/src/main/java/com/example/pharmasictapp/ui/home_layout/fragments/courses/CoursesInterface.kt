package com.example.pharmasictapp.ui.home_layout.fragments.courses

import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.model.CourseDetails
import com.example.pharmasictapp.utils.COURSE_DETAILS
import com.example.pharmasictapp.utils.COURSE_REGISTER
import com.example.pharmasictapp.utils.UPCOMING_COURSES
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CoursesInterface {

    @GET(UPCOMING_COURSES)
    suspend fun getUpComingCourses():Response<List<Course>>


    @GET(COURSE_DETAILS)
    suspend fun getCourseDetails(@Query("id")id:Int):Response<CourseDetails>

    @POST(COURSE_REGISTER)
    suspend fun courseRegister(@Field("UserId")userId:String,@Field("CourseId")courseId:Int):Response<Boolean>



}