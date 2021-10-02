package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class EventsAdapter :RecyclerView.Adapter<EventViewHolder>(){

    private  lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.event_home_item,parent,false)
        firebaseAnalytics = Firebase.analytics
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {

      /*  holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("MyUpcomingEvents"){
                param("EventId","$position")
            }
        }*/

    }

    override fun getItemCount(): Int {
        return 5
    }


}

class EventViewHolder(view: View):RecyclerView.ViewHolder(view){

}