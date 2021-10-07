package com.example.pharmasictapp.ui.home_layout.fragments.courses.mycourses

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity

class MyCoursesAdapter : RecyclerView.Adapter<MyCoursesViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.course_item,parent,false)
        return MyCoursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCoursesViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent: Intent = Intent(holder.itemView.context, CoursesDetailsActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return 6
    }
}

class MyCoursesViewHolder (view: View): RecyclerView.ViewHolder(view){

}