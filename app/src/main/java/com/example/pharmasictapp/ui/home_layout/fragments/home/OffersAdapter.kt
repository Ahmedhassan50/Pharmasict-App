package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class OffersAdapter : RecyclerView.Adapter<OfferViewHolder>(){


    private  lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.offers_item,parent,false)
        firebaseAnalytics = Firebase.analytics
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.offerText.text = "Offer ${position+1}"

       /* holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("Offers&Promotions"){
                param("OfferId","$position")
            }
        }*/


    }

    override fun getItemCount(): Int {
        return 5
    }


}

class OfferViewHolder(view: View): RecyclerView.ViewHolder(view){
    var offerText:TextView=view.findViewById(R.id.offerText)

}