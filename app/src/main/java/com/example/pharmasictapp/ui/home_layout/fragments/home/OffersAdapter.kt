package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.Offer
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class OffersAdapter : RecyclerView.Adapter<OfferViewHolder>(){

    private var offerList:ArrayList<Offer> =ArrayList()
    private  lateinit var firebaseAnalytics: FirebaseAnalytics

    @SuppressLint("NotifyDataSetChanged")
    fun setList(offerList:ArrayList<Offer>){
        this.offerList =offerList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =inflater.inflate(R.layout.offers_item,parent,false)
        firebaseAnalytics = Firebase.analytics
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer=offerList[position]
        holder.bind(offer)

        holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("Offers&Promotions"){
                param("OfferId","${offer.id}")
            }
        }


    }

    override fun getItemCount(): Int {
        return offerList.size
    }


}

class OfferViewHolder(view: View): RecyclerView.ViewHolder(view){
    var offerImage:ImageView=view.findViewById(R.id.offerImage)

    fun bind(offer:Offer){
        Glide.with(offerImage.rootView)
            .load("http://pharmacist-001-site1.htempurl.com/Files/OffersPromotions/${offer.imgName}")
            .into(offerImage)
    }

}