package com.example.pharmasictapp.ui.home_layout.fragments.courses


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.pharmasictapp.R
import com.example.pharmasictapp.ui.home_layout.fragments.courses.mycourses.MyCoursesFragment
import com.example.pharmasictapp.ui.home_layout.fragments.courses.upcoming_courses.UpComCoursesFragment
import com.google.android.material.tabs.TabLayout

class CoursesFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val view:View = inflater.inflate(R.layout.courses_view,container,false)
        addCoursesTabFragment(view)
        return view
    }




   private fun addCoursesTabFragment(view:View){
       val coursesViewPager: ViewPager =view.findViewById(R.id.coursesViewPager)
       val coursesTapLayout:TabLayout=view.findViewById(R.id.coursesTap)
       val fragmentAdapter=CoursesFragmentsAdapter(childFragmentManager)

       fragmentAdapter.addFragment(UpComCoursesFragment(),"Upcoming Courses")
       fragmentAdapter.addFragment(MyCoursesFragment(),"My Courses")
       coursesViewPager.adapter=fragmentAdapter
       coursesTapLayout.setupWithViewPager(coursesViewPager)
       coursesTapLayout.setSelectedTabIndicatorColor(Color.parseColor("#092769"))

   }


}