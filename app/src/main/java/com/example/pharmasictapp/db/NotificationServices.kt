package com.example.pharmasictapp.db

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.R




class NotificationServices :FirebaseMessagingService() {
    var NOTIFICATION_CHANNEL_ID = "net.larntech.notification"
    val NOTIFICATION_ID = 100
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
       super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.size > 0) {
            val title = remoteMessage.notification?.title
            val body = remoteMessage.notification?.body
            sendNotification(title.toString(), body.toString())
        } else {
            val title = remoteMessage.notification!!.title
            val body = remoteMessage.notification!!.body
            sendNotification( title.toString(), body.toString())
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    private fun sendNotification(title: String, messageBody: String) {
        val intent = Intent(this, CoursesDetailsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("title",title)
        intent.putExtra("msg",messageBody)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this)
            .setSmallIcon(com.example.pharmasictapp.R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(messageBody)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }

}