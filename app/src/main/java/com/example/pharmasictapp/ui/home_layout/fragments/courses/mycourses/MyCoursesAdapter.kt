package com.example.pharmasictapp.ui.home_layout.fragments.courses.mycourses

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity

class MyCoursesAdapter : RecyclerView.Adapter<MyCoursesViewHolder>(){

    private var coursesList:ArrayList<Course> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(coursesList:ArrayList<Course>){
        this.coursesList=coursesList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.course_item,parent,false)
        return MyCoursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCoursesViewHolder, position: Int) {
        val course=coursesList[position]
        holder.bind(course)
        holder.itemView.setOnClickListener{
            val intent: Intent = Intent(holder.itemView.context, CoursesDetailsActivity::class.java)
            intent.putExtra("courseId",course.courseId)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }
}

class MyCoursesViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val title: TextView =view.findViewById(R.id.upComingTitle)
    private val description: TextView =view.findViewById(R.id.upComingDescription)
    private val startDate: TextView =view.findViewById(R.id.upComingStartDate)
    private val endDate: TextView =view.findViewById(R.id.upComingEndDate)
    private val courseType: TextView =view.findViewById(R.id.upComingType)



    fun bind(course: Course){
        title.text=course.title
        description.text=course.description
        startDate.text=course.startDate
        endDate.text=course.endDate
        courseType.text=course.courseTypeName

    }
}