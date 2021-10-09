package com.example.pharmasictapp.ui.home_layout.fragments.courses.mycourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.LoggingUserInfo
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CourseItemSeparatedSpace
import com.example.pharmasictapp.ui.home_layout.fragments.courses.upcoming_courses.UpComingViewModel
import me.farahani.spaceitemdecoration.SpaceItemDecoration

class MyCoursesFragment:Fragment() {
    lateinit var viewMode:MyCoursesViewModel
    lateinit var myCoursesAdapter: MyCoursesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_courses,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMode= ViewModelProvider(requireActivity())[MyCoursesViewModel::class.java]
        myCoursesAdapter= MyCoursesAdapter()
        val  myCoursesRv= view.findViewById<RecyclerView>(R.id.myCoursesRV)
        val progressBar: ProgressBar =view.findViewById(R.id.myCoursesProgressBar)
        myCoursesRv.layoutManager= LinearLayoutManager(view.context)
        myCoursesRv.addItemDecoration(CourseItemSeparatedSpace(40))
        myCoursesRv.adapter=myCoursesAdapter

        if (LoggingUserInfo.getToken()!=null){

            viewMode.getMyCourses(LoggingUserInfo.getId().toString())
            progressBar.visibility=View.VISIBLE

            viewMode.myCoursesLiveData.observe(viewLifecycleOwner,{
                if(it!=null){
                    myCoursesAdapter.setList(it as ArrayList<Course>)
                    progressBar.visibility=View.GONE


                }
                viewMode.clearData()
            })
        }

    }
}