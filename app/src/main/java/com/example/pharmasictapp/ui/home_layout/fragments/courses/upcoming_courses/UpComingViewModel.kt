package com.example.pharmasictapp.ui.home_layout.fragments.courses.upcoming_courses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.network.ApiService
import com.example.pharmasictapp.db.repositories.CourseRepository
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CoursesInterface
import kotlinx.coroutines.launch

class UpComingViewModel :ViewModel() {

    private var courseRepository:CourseRepository
    var upComingCoursesLiveData =MutableLiveData<List<Course>>()
    val upComingCourses:LiveData<List<Course>> get() = upComingCoursesLiveData
    init {
      val serviceInstance = ApiService.getRetrofitBuilder().create(CoursesInterface::class.java)
        courseRepository= CourseRepository(serviceInstance)

    }


    fun getUpComingCourses()=viewModelScope.launch{

       val result=  courseRepository.getUpComingCourses()
        if(result.isSuccessful){
            if(result.body()!=null){
              upComingCoursesLiveData.postValue(result.body())
            }
        }else{
            Log.i("upComing",result.message())

        }

    }


}