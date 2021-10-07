package com.example.pharmasictapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pharmasictapp.db.LoggingUserInfo
import com.example.pharmasictapp.ui.home_layout.HomeLayout
import com.example.pharmasictapp.ui.login.LoginActivity
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val sharedPref=getSharedPreferences("autoLogin", MODE_PRIVATE)
        val isLogin = sharedPref.getString("userData",null)
        if (isLogin != null){
            val userData = JSONObject(isLogin)
            LoggingUserInfo.setId(userData.get("id").toString())
            LoggingUserInfo.setEmailAddress(userData.get("email").toString())
            LoggingUserInfo.setName(userData.get("name").toString())
            LoggingUserInfo.setPhoneNumber(userData.get("photoName").toString())
            LoggingUserInfo.setToken(userData.get("token").toString())
            val intent: Intent = Intent(this@MainActivity, HomeLayout::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent: Intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}