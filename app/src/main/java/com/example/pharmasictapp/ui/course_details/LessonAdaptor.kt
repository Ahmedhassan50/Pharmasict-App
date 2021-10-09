package com.example.pharmasictapp.ui.course_details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Course
import com.example.pharmasictapp.db.model.Lecture
import com.google.android.material.imageview.ShapeableImageView

class LessonAdaptor (): RecyclerView.Adapter<LessonAdaptor.MyViewHolder>(){
    private var lessonsList:ArrayList<Lecture> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(lessonList:ArrayList<Lecture>){
        this.lessonsList=lessonList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview)
    {
        val lessonName: TextView =itemview.findViewById(R.id.tv_course_details_lesson_item)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val i= LayoutInflater.from(parent.context).inflate(R.layout.lesson_item,parent,false)
        return MyViewHolder(i)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        val lesson=lessonsList[position]
        holder.lessonName.text=lesson.lectureName

    }

    override fun getItemCount(): Int
    {
        return lessonsList.size
    }
}