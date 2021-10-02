package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.model.BannerItem
import com.example.pharmasictapp.R
import com.example.pharmasictapp.SeparatedSpace

class HomeFragment:Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_home,container,false)
    }
    private val bannerItems= mutableListOf<BannerItem>().apply {
        add(BannerItem(id=0,imageUrl="https://student.valuxapps.com/storage/uploads/banners/1619472351ITAM5.3bb51c97376281.5ec3ca8c1e8c5.jpg"))
        add(BannerItem(id=1,imageUrl="https://student.valuxapps.com/storage/uploads/banners/1619472116OYHxC.45b7de97376281.5ec3ca8c1d324.jpg"))
        add(BannerItem(id=2,imageUrl="https://student.valuxapps.com/storage/uploads/banners/1626544896muQ0Q.best-deal-promotional-ribbon-style-green-banner-design_1017-27469.jpg"))
        add(BannerItem(id=3,imageUrl="https://student.valuxapps.com/storage/uploads/banners/1626545208UfigP.golden-coin-money-cashback-promotion-ecommerce-poster-banner-template-blue-background-216757528.jpg"))
        //add(BannerItem(id=4,imageUrl="https://student.valuxapps.com/storage/uploads/banners/16283378549Vinn.banner foods@2x.png"))


    }
    val handler = Handler()
    private lateinit  var banner: ViewPager2


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        banner =view.findViewById(R.id.bannerViewer)
        val adapter= BannerAdapter(bannerItems)
        banner.adapter=adapter
        banner.clipToPadding=false
        banner.clipChildren=false
        banner.getChildAt(0).overScrollMode= RecyclerView.OVER_SCROLL_NEVER
        banner.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(bannerRun)
                handler.postDelayed(bannerRun,3000)

            }

        })

        val eventRv: RecyclerView =view.findViewById(R.id.event_RV)
//        eventRv.layoutManager= LinearLayoutManager(view.context, RecyclerView.HORIZONTAL,false)

        eventRv.layoutManager =object : LinearLayoutManager(view.context, RecyclerView.HORIZONTAL,false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (width * 0.8).toInt()
                lp.height = (width * 0.7).toInt()
                return true
            }
        }

        eventRv.addItemDecoration(SeparatedSpace(40))




        eventRv.adapter= EventsAdapter()

        eventRv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER



        val offerRv: RecyclerView =view.findViewById(R.id.offer_RV)
        offerRv.layoutManager= object : LinearLayoutManager(view.context, RecyclerView.HORIZONTAL,false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (width * 0.8).toInt()
                lp.height = (width * 0.15).toInt()
                return true
            }
        }
        offerRv.addItemDecoration(SeparatedSpace(40))
        offerRv.adapter= OffersAdapter()
        offerRv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER


    }



    val bannerRun:Runnable= Runnable {

        if(banner.currentItem==bannerItems.size-1){
            banner.currentItem=0
        }else{
            banner.currentItem=banner.currentItem+1
        }

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(bannerRun)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(bannerRun,3000)
    }

}