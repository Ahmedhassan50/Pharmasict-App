package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Event
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class EventsAdapter :RecyclerView.Adapter<EventViewHolder>(){
    private var eventList:ArrayList<Event> =ArrayList()

    private  lateinit var firebaseAnalytics: FirebaseAnalytics



    @SuppressLint("NotifyDataSetChanged")
    fun setList(eventList:ArrayList<Event>){
        this.eventList =eventList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.event_home_item,parent,false)
        firebaseAnalytics = Firebase.analytics
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event=eventList[position]

        holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("MyUpcomingEvents"){
                param("EventId","${event.id}")
            }
        }
        holder.bind(event)

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}

class EventViewHolder(view: View):RecyclerView.ViewHolder(view){
    var eventName:TextView=view.findViewById(R.id.EventName)
    var eventDate:TextView=view.findViewById(R.id.EventDate)
    var eventType:TextView=view.findViewById(R.id.EventType)


    fun bind(event:Event){
        eventName.text=event.name
        eventDate.text=event.date
        eventType.text=event.type
    }



}