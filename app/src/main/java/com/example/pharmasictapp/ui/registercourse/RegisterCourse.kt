package com.example.pharmasictapp.ui.registercourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.pharmasictapp.R
import com.example.pharmasictapp.utils.ValidUserInfo

class RegisterCourse : AppCompatActivity() {
    private lateinit var tvCourseName:TextView
    private lateinit var tvCourseNumber:TextView
    private lateinit var btnConfirm:Button
    private lateinit var etEmail:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_course)
        initRegisterCourse()
        val courseIntent=intent
        val courseName=courseIntent.getStringExtra("courseName")
        tvCourseName.text= courseName
        btnConfirm.setOnClickListener{
            var validUserInfo: Boolean = false

            // check validations
            validUserInfo = validateInputs(etEmail.text.toString())
            if(validUserInfo)
            {
                Toast.makeText(this,"Confirmation Mail is Sent to You",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun initRegisterCourse(){
        tvCourseName=findViewById(R.id.course_register_name)
        tvCourseNumber=findViewById(R.id.tv_registration_number)
        btnConfirm=findViewById(R.id.btn_register_course_send)
        etEmail=findViewById(R.id.et_register_course_email)


    }
    private fun validateInputs(email: String): Boolean {
        var valid=false
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


        return valid

    }
}