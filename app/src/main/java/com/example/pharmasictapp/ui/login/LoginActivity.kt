package com.example.pharmasictapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.pharmasictapp.R
import com.example.pharmasictapp.ui.course_details.CoursesDetailsActivity
import com.example.pharmasictapp.ui.home_layout.HomeLayout
import com.example.pharmasictapp.utils.CheckCredentials
import com.example.pharmasictapp.utils.ValidUserInfo
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var  etPassword:EditText
    private lateinit var  etEmail:EditText
    private lateinit var  btnSkip:ImageButton
    private lateinit var  tvForgetPassword:TextView
    private lateinit var  tvSignUp:TextView
    private lateinit var  btnLogin:Button
    private  lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initMainActivity()
        FirebaseApp.initializeApp(this)
          firebaseAnalytics = Firebase.analytics

        btnLogin.setOnClickListener {
            var validCredentials: Boolean = false
            var validUserInfo: Boolean = false

            //get the inputs
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()


            // check validations
            validUserInfo = validateInputs(email, password)

            if (validUserInfo) {
                // check credentials
                validCredentials = checkCredentials(email, password)
            }

            if (validCredentials) {

                firebaseAnalytics.logEvent("Login", null)
                // go to home activity

                val intent: Intent = Intent(this@LoginActivity, HomeLayout::class.java)
                startActivity(intent)
            }


        }

        btnSkip.setOnClickListener {
            // go to home activity as a guest
            firebaseAnalytics.logEvent("skipClicked",null)
            val intent: Intent = Intent(this@LoginActivity, HomeLayout::class.java)
            startActivity(intent)
        }

        tvSignUp.setOnClickListener {
            // go to sign up activity

        }
        tvForgetPassword.setOnClickListener {
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        var valid=false
        var passwordValid=false
        when {
            ValidUserInfo.validEmailAddress(email)== ValidUserInfo.EMPTY -> {
                etEmail.error="Please Enter Email Address"


            }
            ValidUserInfo.validEmailAddress(email)== ValidUserInfo.NOT_EMAIL_FORM -> {
                etEmail.error="Not Valid Email Format"

            }
            else -> {
                etEmail.error=null
                valid=true
            }
        }
        when {
            ValidUserInfo.validPassword(password)== ValidUserInfo.EMPTY -> {
                etPassword.error="Please Enter your Password"


            }
            ValidUserInfo.validPassword(password)== ValidUserInfo.NOT_VALID -> {
                etPassword.error="Password must be 8 digits at least"

            }
            else -> {
                etPassword.error=null
                passwordValid=true
            }
        }

        return passwordValid&&valid

    }

    private fun checkCredentials(email: String, password: String):Boolean {
        var valid=false
        var passwordValid=false
        if(CheckCredentials.checkEmail(email)== CheckCredentials.NOT_VALID)
        {

            etEmail.error="Wrong Email Address"

        }
        else
        {
            valid=true
            etEmail.error=null

        }

        if(CheckCredentials.checkPassword(password)== CheckCredentials.NOT_VALID){
            etPassword.error="Wrong Password"
        }
        else
        {
            passwordValid=true
            etPassword.error=null

        }
        return valid&&passwordValid

    }



    private fun initMainActivity() {

        btnLogin=findViewById(R.id.btn_login_loginBtn)
        tvForgetPassword=findViewById(R.id.tv_login_forget_password)
        tvSignUp=findViewById(R.id.tv_login_signUp)
        btnSkip=findViewById(R.id.img_btn_login_skip)
        etEmail=findViewById(R.id.et_login_email)
        etPassword=findViewById(R.id.et_login_password)


    }


}