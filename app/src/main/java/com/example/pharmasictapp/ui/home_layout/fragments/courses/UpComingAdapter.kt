package com.example.pharmasictapp.ui.home_layout.fragments.courses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R

class UpComingAdapter  :RecyclerView.Adapter<UpComingViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.course_item,parent,false)
        return UpComingViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 17
    }
}

class UpComingViewHolder (view: View):RecyclerView.ViewHolder(view){

}

