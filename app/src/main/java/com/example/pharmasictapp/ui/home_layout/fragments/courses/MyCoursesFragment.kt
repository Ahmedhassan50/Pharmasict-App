package com.example.pharmasictapp.ui.home_layout.fragments.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import me.farahani.spaceitemdecoration.SpaceItemDecoration

class MyCoursesFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_courses,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  myCoursesRv= view.findViewById<RecyclerView>(R.id.myCoursesRV)
        myCoursesRv.layoutManager= GridLayoutManager(view.context,2)
        myCoursesRv.addItemDecoration(SpaceItemDecoration(40, true))
        myCoursesRv.adapter=MyCoursesAdapter()
    }
}