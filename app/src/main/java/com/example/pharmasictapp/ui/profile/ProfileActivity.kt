package com.example.pharmasictapp.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pharmasictapp.R
import com.example.pharmasictapp.databinding.ActivityProfileBinding
import com.example.pharmasictapp.db.LoggingUserInfo

class ProfileActivity : AppCompatActivity() {

    lateinit var binding:ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text= LoggingUserInfo.getName()
        binding.tvPhoneNumber .text= LoggingUserInfo.phoneNumber()
        binding.profileName.text=LoggingUserInfo.getName()
        binding.profilePhone.text =LoggingUserInfo.phoneNumber()
        binding.email.text =LoggingUserInfo.getEmailAddress()

    }
}