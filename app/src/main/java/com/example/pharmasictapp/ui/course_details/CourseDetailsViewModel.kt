package com.example.pharmasictapp.ui.course_details

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

    private var courseRepository: CourseRepository
    init {
        val serviceInstance = ApiService.getRetrofitBuilder().create(CoursesInterface::class.java)
        courseRepository= CourseRepository(serviceInstance)
    }

    fun clearData(){
        courseDetailsMutableLiveData.postValue(null)
    }


    fun getCourseDetails(id:Int)=viewModelScope.launch {
        val result=courseRepository.getCourseDetails(id)
        if (result.isSuccessful){
            if (result.body()!=null){
                courseDetailsMutableLiveData.postValue(result.body())

            }
        }
    }
}