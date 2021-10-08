package com.example.pharmasictapp.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pharmasictapp.databinding.ActivityProfileBinding
import com.example.pharmasictapp.db.LoggingUserInfo
import com.example.pharmasictapp.ui.login.LoginActivity

class ProfileActivity : AppCompatActivity() {

    lateinit var binding:ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text= LoggingUserInfo.getName()
        binding.tvPhoneNumber.text= LoggingUserInfo.phoneNumber()
        binding.profileName.text=LoggingUserInfo.getName()
        binding.profilePhone.text =LoggingUserInfo.phoneNumber()
        binding.email.text =LoggingUserInfo.getEmailAddress()
        binding.logout.setOnClickListener{
            val sharedPref=getSharedPreferences("autoLogin", MODE_PRIVATE)
            sharedPref.edit().clear().apply()
            LoggingUserInfo.setToken(null)
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }

    }
}