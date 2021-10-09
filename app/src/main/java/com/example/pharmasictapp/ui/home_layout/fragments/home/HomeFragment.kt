package com.example.pharmasictapp.ui.home_layout.fragments.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.pharmasictapp.R
import com.example.pharmasictapp.SeparatedSpace
import com.example.pharmasictapp.db.LoggingUserInfo
import com.example.pharmasictapp.db.model.BannerItem
import com.example.pharmasictapp.db.model.Event
import com.example.pharmasictapp.db.model.Offer
import com.example.pharmasictapp.utils.LoadingDialog

class HomeFragment : Fragment() {

   private lateinit var eventsAdapter:EventsAdapter
   private lateinit var offersAdapter:OffersAdapter
    private lateinit var bannerssAdapter:BannerAdapter
   private lateinit var viewModel:HomeViewModel
   private lateinit var loadingDialog: LoadingDialog


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_home, container, false)
    }


    val handler = Handler()
    private lateinit var banner: ViewPager2


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        eventsAdapter= EventsAdapter()
        offersAdapter= OffersAdapter()
        bannerssAdapter= BannerAdapter()
        banner = view.findViewById(R.id.bannerViewer)
        loadingDialog= LoadingDialog(requireActivity())
        val adapter = bannerssAdapter
        banner.adapter = adapter
        banner.clipToPadding = false
        banner.clipChildren = false
        banner.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        banner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(bannerRun)
                handler.postDelayed(bannerRun, 3000)

            }

        })

        val eventRv: RecyclerView = view.findViewById(R.id.event_RV)
//        eventRv.layoutManager= LinearLayoutManager(view.context, RecyclerView.HORIZONTAL,false)

        eventRv.layoutManager =
            object : LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                    // force height of viewHolder here, this will override layout_height from xml
                    lp.width = (width * 0.8).toInt()
                    lp.height = (width * 0.7).toInt()
                    return true
                }
            }

        eventRv.addItemDecoration(SeparatedSpace(40))
        eventRv.adapter = eventsAdapter
        eventRv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val offerRv: RecyclerView = view.findViewById(R.id.offer_RV)
        offerRv.layoutManager =
            object : LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                    // force height of viewHolder here, this will override layout_height from xml
                   // lp.width = (width * 0.8).toInt()
                    lp.height = (width * 0.15).toInt()
                    return true
                }
            }
        offerRv.addItemDecoration(SeparatedSpace(20))
        offerRv.adapter = offersAdapter
        offerRv.overScrollMode = RecyclerView.OVER_SCROLL_NEVER





        viewModel.getHomeData()
        loadingDialog.startLoadingDialog()
        viewModel.homeLiveData.observe(viewLifecycleOwner,{
            if(it!=null){
                if(LoggingUserInfo.getToken()!=null){
                    eventsAdapter.setList(it.eventList as ArrayList<Event>)
                }

                offersAdapter.setList(it.offerList as ArrayList<Offer>)
                bannerssAdapter.setList(it.carouselList as ArrayList<BannerItem>)
                loadingDialog.dismissDialog()
        }
            viewModel.clearData()


        })










    }


    val bannerRun: Runnable = Runnable {

        if (banner.currentItem == 4) {
            banner.currentItem = 0
        } else {
            banner.currentItem = banner.currentItem + 1
        }

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(bannerRun)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(bannerRun, 3000)
    }

}