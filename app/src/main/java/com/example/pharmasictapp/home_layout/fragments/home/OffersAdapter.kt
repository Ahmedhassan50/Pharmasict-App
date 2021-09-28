package com.example.pharmasictapp.home_layout.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmasictapp.R

class OffersAdapter : RecyclerView.Adapter<OfferViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.offers_item,parent,false)

        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.offerText.text="Offer ${position+1}"

    }

    override fun getItemCount(): Int {
        return 5
    }


}

class OfferViewHolder(view: View): RecyclerView.ViewHolder(view){
    var offerText:TextView=view.findViewById(R.id.offerText)

}