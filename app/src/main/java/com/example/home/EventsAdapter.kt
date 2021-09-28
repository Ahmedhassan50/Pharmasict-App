package com.example.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R

class EventsAdapter :RecyclerView.Adapter<EventViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.event_home_item,parent,false)

        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }


}

class EventViewHolder(view: View):RecyclerView.ViewHolder(view){

}