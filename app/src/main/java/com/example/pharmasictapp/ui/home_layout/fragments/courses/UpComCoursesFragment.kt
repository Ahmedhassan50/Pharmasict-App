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

class UpComCoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.upcoming_courses,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val upComingRv= view.findViewById<RecyclerView>(R.id.upcomingCoursesRV)
        upComingRv.layoutManager= GridLayoutManager(view.context,2)
        upComingRv.addItemDecoration(SpaceItemDecoration(40, true))
        upComingRv.adapter=UpComingAdapter()


    }
}