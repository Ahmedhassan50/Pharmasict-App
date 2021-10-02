package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.model.BannerItem
import com.example.pharmasictapp.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class BannerAdapter(private val bannerItems:MutableList<BannerItem>):RecyclerView.Adapter<BannerViewHolder>() {


    private  lateinit var firebaseAnalytics: FirebaseAnalytics



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
      val inflater =LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.banner_item,parent,false)
        firebaseAnalytics = Firebase.analytics

        return BannerViewHolder(view)
    }


    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem=bannerItems[position]
        Glide.with(holder.bannerImage.rootView)
            .load(bannerItem.imageUrl).into(holder.bannerImage)
        holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("CarouselOfBanners"){
                param("BannerId","${bannerItem.id}")
            }
        }





    }


    override fun getItemCount(): Int {
        return bannerItems.size
    }



}
class  BannerViewHolder(view:View):RecyclerView.ViewHolder(view){
    var bannerImage:ImageView=view.findViewById(R.id.bannerImage)

}