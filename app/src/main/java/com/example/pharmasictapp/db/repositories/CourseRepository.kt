package com.example.pharmasictapp.db.repositories

import com.example.pharmasictapp.ui.home_layout.fragments.courses.CoursesInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CourseRepository(private val api:CoursesInterface) {

    suspend fun getUpComingCourses()= withContext(Dispatchers.IO){
        api.getUpComingCourses()
    }
}