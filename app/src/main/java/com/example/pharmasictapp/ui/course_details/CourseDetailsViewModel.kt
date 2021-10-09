package com.example.pharmasictapp.ui.course_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmasictapp.db.model.CourseDetails
import com.example.pharmasictapp.db.network.ApiService
import com.example.pharmasictapp.db.repositories.CourseRepository
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CoursesInterface
import kotlinx.coroutines.launch

class CourseDetailsViewModel:ViewModel() {

    private var courseDetailsMutableLiveData=MutableLiveData<CourseDetails?>()
    val courseDetailsLiveData:LiveData<CourseDetails?> get() = courseDetailsMutableLiveData

    private var courseRegisterMutableLiveData=MutableLiveData<Boolean?>()
    val courseRegisterLiveData:LiveData<Boolean?> get() = courseRegisterMutableLiveData

    private var courseRepository: CourseRepository

    init {
        val serviceInstance = ApiService.getRetrofitBuilder().create(CoursesInterface::class.java)
        courseRepository= CourseRepository(serviceInstance)
    }

    fun clearData(){
        courseDetailsMutableLiveData.postValue(null)
    }
    fun cleaRegisterData(){
        courseRegisterMutableLiveData.postValue(null)
    }


    fun getCourseDetails(id:Int)=viewModelScope.launch {
        val result=courseRepository.getCourseDetails(2)
        if (result.isSuccessful){
            if (result.body()!=null){
                courseDetailsMutableLiveData.postValue(result.body())
                Log.i("dfdf","${result.body().toString()}")

            }
        }
    }

    fun courseRegister(userId:String,courseId:Int)=viewModelScope.launch{
        val result=courseRepository.courseRegister(userId,courseId)
        if(result.isSuccessful){
           // courseRegisterMutableLiveData.postValue(result.body()?.get("isSuccess")?.asBoolean)
            courseRegisterMutableLiveData.postValue(true)
        }else{
            Log.i("error","${result}")
        }
    }

    fun sendEmail(email:String,courseName:String)=viewModelScope.launch {
        val result=courseRepository.sendEmail(email,courseName)
        if (result.isSuccessful){
            Log.i("dfdf","${result.body()}")
        }
    }



}