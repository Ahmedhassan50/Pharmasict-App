package com.example.pharmasictapp.ui.Logic

class ValidUserInfo
{
    companion object
    {
        const val EMPTY=2
        const val NOT_EMAIL_FORM=1
        const val VALID =0
        const val NOT_VALID = 3



        fun validEmailAddress(email:String):Int
        {
            return when {
                email.isEmpty() -> EMPTY
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches().not() -> NOT_EMAIL_FORM
                else -> VALID
            }
        }

        fun validPassword(pass:String):Int
        {
            return when {
                pass.isEmpty() -> EMPTY
                pass.length<8 -> NOT_VALID
                else -> VALID
            }
        }

    }
}