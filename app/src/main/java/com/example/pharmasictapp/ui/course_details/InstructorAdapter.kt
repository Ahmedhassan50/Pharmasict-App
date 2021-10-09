package com.example.pharmasictapp.ui.course_details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Instructor
import com.example.pharmasictapp.db.model.Lecture

class InstructorAdapter(): RecyclerView.Adapter<InstructorAdapter.InstructorViewHolder>()
{
    private var instructorList:ArrayList<Instructor> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(instructorList:ArrayList<Instructor>){
        this.instructorList=instructorList
        notifyDataSetChanged()
    }


    class InstructorViewHolder(itemview: View): RecyclerView.ViewHolder(itemview)
    {
        val instructorName: TextView =itemview.findViewById(R.id.tv_course_details_instructor_name_item)
        val instructorDescription: TextView=itemview.findViewById(R.id.tv_course_details_instructor_desc_item)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstructorViewHolder {
        val i= LayoutInflater.from(parent.context).inflate(R.layout.instructor_item,parent,false)
        return InstructorViewHolder(i)

    }

    override fun onBindViewHolder(holder: InstructorViewHolder, position: Int)
    {
        val instructor=instructorList[position]
        holder.instructorName.text=instructor.name
        holder.instructorDescription.text=instructor.about
       /* holder.instructorName.text=instructor.getName()
        holder.instructorDescription.text=instructor.getDescription()*/


    }

    override fun getItemCount(): Int
    {
        return instructorList.size
    }




}