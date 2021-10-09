package com.example.pharmasictapp.ui.home_layout.fragments.courses.upcoming_courses

import android.os.Bundle
import android.util.Log
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
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.ui.home_layout.fragments.courses.CourseItemSeparatedSpace
import me.farahani.spaceitemdecoration.SpaceItemDecoration

class UpComCoursesFragment : Fragment() {

   private val upComingAdapter:UpComingAdapter by lazy{
        UpComingAdapter()
    }
    lateinit var viewMode:UpComingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.upcoming_courses,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMode= ViewModelProvider(requireActivity())[UpComingViewModel::class.java]
        val upComingRv= view.findViewById<RecyclerView>(R.id.upcomingCoursesRV)
        upComingRv.layoutManager= LinearLayoutManager(view.context)
        upComingRv.addItemDecoration(CourseItemSeparatedSpace(40))
        upComingRv.adapter=upComingAdapter
        val progressBar:ProgressBar=view.findViewById(R.id.upComProgressBar)

        viewMode.getUpComingCourses()

        progressBar.visibility=View.VISIBLE

        viewMode.upComingCourses.observe(viewLifecycleOwner,{
            if(it!=null){
                upComingAdapter.setList(it as ArrayList<Course>)
                progressBar.visibility=View.GONE
                viewMode.upComingCoursesLiveData.value=null

            }
        })

    }





}