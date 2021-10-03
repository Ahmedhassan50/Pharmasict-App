package com.example.pharmasictapp.ui.home_layout.fragments.courses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R

class MyCoursesAdapter : RecyclerView.Adapter<MyCoursesViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.course_item,parent,false)
        return MyCoursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCoursesViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 6
    }
}

class MyCoursesViewHolder (view: View): RecyclerView.ViewHolder(view){

}