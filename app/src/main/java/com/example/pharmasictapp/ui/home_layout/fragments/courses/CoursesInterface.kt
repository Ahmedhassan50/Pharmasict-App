package com.example.pharmasictapp.ui.home_layout.fragments.courses

import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.model.CourseDetails
import com.example.pharmasictapp.db.model.CourseInfo
import com.example.pharmasictapp.db.model.SendEmail
import com.example.pharmasictapp.utils.*
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*

interface CoursesInterface {

    @GET(UPCOMING_COURSES)
    suspend fun getUpComingCourses():Response<List<Course>>


    @GET(COURSE_DETAILS)
    suspend fun getCourseDetails(@Query("id")id:Int):Response<CourseDetails>

    @GET(GET_MY_COURSES)
    suspend fun getMyCourses(@Query("UserId")userId:String):Response<List<Course>>

    @POST(COURSE_REGISTER)
    suspend fun courseRegister(@Body courseInfo: CourseInfo):Response<JsonObject>

    @Headers("Authorization: Bearer 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")
    @POST(SEND_EMAIL)
    suspend fun sendEmail(@Body emailInfo:SendEmail):Response<ResponseBody>

}