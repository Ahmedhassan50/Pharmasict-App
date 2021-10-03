package com.example.pharmasictapp.ui.home_layout.fragments.courses

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity
import com.example.pharmasictapp.ui.home_layout.HomeLayout

class UpComingAdapter  :RecyclerView.Adapter<UpComingViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.course_item,parent,false)
        return UpComingViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val intent: Intent = Intent(holder.itemView.context, CoursesDetailsActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
       return 17
    }
}

class UpComingViewHolder (view: View):RecyclerView.ViewHolder(view){

}

