package com.example.pharmasictapp.utils

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import com.example.pharmasictapp.R

class LoadingDialog (private val activity:Activity ){

    private lateinit var dialog : Dialog

    fun startLoadingDialog(){
        dialog = Dialog(activity)
        val inflater:LayoutInflater= activity.layoutInflater
        val view: View =inflater.inflate(R.layout.loading_dialog,null)
         dialog.setContentView(view)



        dialog.setCancelable(false)

        dialog.show()

    }

    fun dismissDialog(){
        dialog.dismiss()
    }
}