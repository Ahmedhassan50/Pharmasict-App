package com.example.pharmasictapp.ui.home_layout.fragments.courses.mycourses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.network.ApiService
import com.example.pharmasictapp.db.repositories.CourseRepository
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CoursesInterface
import kotlinx.coroutines.launch

class MyCoursesViewModel:ViewModel() {
    private var courseRepository: CourseRepository
    var myCoursesMutableLiveData = MutableLiveData<List<Course>?>()
    val myCoursesLiveData: LiveData<List<Course>?> get() = myCoursesMutableLiveData

    init {
        val serviceInstance = ApiService.getRetrofitBuilder().create(CoursesInterface::class.java)
        courseRepository= CourseRepository(serviceInstance)
    }
    fun clearData(){
        myCoursesMutableLiveData.postValue(null)
    }

    fun getMyCourses(userId:String)=viewModelScope.launch {
        val result=courseRepository.getMyCourses(userId)
        if(result.isSuccessful){
            if(result.body()!=null){
                myCoursesMutableLiveData.postValue(result.body())
            }
        }
    }
}