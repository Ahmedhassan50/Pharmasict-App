package com.example.home

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

class BannerAdapter(private val bannerItems:MutableList<BannerItem>):RecyclerView.Adapter<BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
      val inflater =LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.banner_item,parent,false)

        return BannerViewHolder(view)
    }


    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem=bannerItems[position]
        Glide.with(holder.bannerImage.rootView)
            .load(bannerItem.imageUrl).into(holder.bannerImage)
        holder.bannerImage.setOnClickListener{

        }




    }


    override fun getItemCount(): Int {
        return bannerItems.size
    }



}
class  BannerViewHolder(view:View):RecyclerView.ViewHolder(view){
    var bannerImage:ImageView=view.findViewById(R.id.bannerImage)

}