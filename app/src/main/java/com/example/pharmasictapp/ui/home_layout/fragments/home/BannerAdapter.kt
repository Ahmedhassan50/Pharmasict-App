package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.model.BannerItem
import com.example.pharmasictapp.db.model.Event
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class BannerAdapter():RecyclerView.Adapter<BannerViewHolder>() {
    private var bannerList:ArrayList<BannerItem> =ArrayList()

    private  lateinit var firebaseAnalytics: FirebaseAnalytics

    @SuppressLint("NotifyDataSetChanged")
    fun setList(bannerList:ArrayList<BannerItem>){
        this.bannerList =bannerList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
      val inflater =LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.banner_item,parent,false)
        firebaseAnalytics = Firebase.analytics

        return BannerViewHolder(view)
    }


    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem=bannerList[position]
        Glide.with(holder.bannerImage.rootView)
            .load("http://pharmacist-001-site1.htempurl.com${bannerItem.imageUrl}").into(holder.bannerImage)
        holder.itemView.setOnClickListener{
//            Log.i("bannner","$position")
            firebaseAnalytics.logEvent("CarouselOfBanners"){
                param("BannerId","${bannerItem.id}")
            }
        }





    }


    override fun getItemCount(): Int {
        return bannerList.size
    }



}
class  BannerViewHolder(view:View):RecyclerView.ViewHolder(view){
    var bannerImage:ImageView=view.findViewById(R.id.bannerImage)

}