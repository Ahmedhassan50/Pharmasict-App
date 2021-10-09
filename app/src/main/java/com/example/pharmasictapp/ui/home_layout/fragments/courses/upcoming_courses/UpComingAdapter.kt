package com.example.pharmasictapp.ui.home_layout.fragments.courses.upcoming_courses

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity
import com.example.pharmasictapp.ui.home_layout.HomeLayout

class UpComingAdapter  :RecyclerView.Adapter<UpComingViewHolder>(){
  private var coursesList:ArrayList<Course> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(coursesList:ArrayList<Course>){
        this.coursesList=coursesList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.course_item,parent,false)
        return UpComingViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {
        val course=coursesList[position]
        holder.bind(course)
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context, CoursesDetailsActivity::class.java)
            intent.putExtra("courseId",course.courseId)
            holder.itemView.context.startActivity(intent)
        }



    }

    override fun getItemCount(): Int {
       return coursesList.size
    }
}

class UpComingViewHolder (view: View):RecyclerView.ViewHolder(view){
    private val title:TextView=view.findViewById(R.id.upComingTitle)
    private val description:TextView=view.findViewById(R.id.upComingDescription)
    private val startDate:TextView=view.findViewById(R.id.upComingStartDate)
    private val endDate:TextView=view.findViewById(R.id.upComingEndDate)
    private val courseType:TextView=view.findViewById(R.id.upComingType)



    fun bind(course: Course){
        title.text=course.title
        description.text=course.description
        startDate.text=course.startDate
        endDate.text=course.endDate
        courseType.text=course.courseTypeName

    }

}

