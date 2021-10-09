package com.example.pharmasictapp.ui.course_details

import android.app.AlertDialog
import android.app.Dialog
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.pharmasictapp.R
import com.google.firebase.messaging.FirebaseMessagingService
import android.app.NotificationChannel

import android.os.Build

import android.content.Context
import com.example.pharmasictapp.ui.registercourse.RegisterCourse


class RegisterDialog: AppCompatDialogFragment() {

     lateinit var courseName:TextView
     lateinit var courseType:TextView
     lateinit var startDate:TextView
     lateinit var endDate:TextView


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
      val  builder= AlertDialog.Builder(activity, com.example.pharmasictapp.R.style.DialogeTheme)

       val layoutinflat=activity?.layoutInflater

        val view=layoutinflat?.inflate(
            com.example.pharmasictapp.R
            .layout.register_to_course_pop_up,null)
        builder.setView(view).setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->  })
            .setPositiveButton("Register", DialogInterface.OnClickListener { dialogInterface, i ->

                val intent=Intent(activity,RegisterCourse::class.java)
                intent.putExtra("courseName",courseName.text.toString())
                startActivity(intent)


            })

        courseName= view?.findViewById(com.example.pharmasictapp.R.id.course_confirmation_name)!!
        courseType=view.findViewById(com.example.pharmasictapp.R.id.course_confirmation_type)
        startDate=view.findViewById(com.example.pharmasictapp.R.id.course_confirmation_start_date)
        endDate=view.findViewById(com.example.pharmasictapp.R.id.course_confirmation_end_date)

        val args=arguments
        val name=args?.getString("name")
        val type =args?.getString("type")
        courseName.text=name
        courseType.text=type
        startDate.text=args?.getString("startDate")
        endDate.text=args?.getString("endDate")

       return builder.create()


    }

}