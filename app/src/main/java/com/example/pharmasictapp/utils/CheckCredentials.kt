package com.example.pharmasictapp.utils

import com.example.pharmasictapp.db.LoggingUserInfo

class CheckCredentials
{
    companion object
    {


         const val  VALID=0
         const val  NOT_VALID=1

        fun checkEmail(email: String):Int
        {
            val currentEmail= LoggingUserInfo.getEmailAddress()

            return if (email == currentEmail) {
                VALID
            } else {
                NOT_VALID
            }

        }

        fun checkPassword(pass: String):Int
        {
            val currentPass= LoggingUserInfo.getPassword()

            return if (pass == currentPass) {
                VALID
            } else {
                NOT_VALID
            }

        }


    }
}