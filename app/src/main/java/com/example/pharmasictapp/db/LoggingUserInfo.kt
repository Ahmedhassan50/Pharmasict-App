package com.example.pharmasictapp.db

object LoggingUserInfo {
      private  var emailAddress:String?=null
      private var password:String?=null
    fun setEmailAddress(Name:String)
    {
        emailAddress =Name
    }
    fun setPassword(Password:String)
    {
        password =Password
    }
    fun getEmailAddress():String
    {
        return emailAddress ?:"n@gmail.com"
    }
    fun getPassword():String
    {
        return password ?:"123456"
    }
}