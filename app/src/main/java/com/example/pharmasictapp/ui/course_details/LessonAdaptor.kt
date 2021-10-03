package com.example.pharmasictapp.ui.course_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.google.android.material.imageview.ShapeableImageView

class LessonAdaptor (private val newlist:ArrayList<String>): RecyclerView.Adapter<LessonAdaptor.MyViewHolder>(){

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
        val lesson=newlist[position]
        holder.lessonName.text=lesson

    }

    override fun getItemCount(): Int
    {
        return newlist.size
    }
}