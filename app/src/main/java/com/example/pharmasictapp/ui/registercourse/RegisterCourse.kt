package com.example.pharmasictapp.ui.registercourse

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.pharmasictapp.R
import com.example.pharmasictapp.ui.course_details.CourseDetailsViewModel
import com.example.pharmasictapp.utils.LoadingDialog
import com.example.pharmasictapp.utils.ValidUserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterCourse : AppCompatActivity() {
    private lateinit var tvCourseName:TextView
    private lateinit var tvCourseNumber:TextView
    private lateinit var btnConfirm:Button
    private lateinit var etEmail:EditText
    private lateinit var loadingDialog: LoadingDialog
    private lateinit var viewModle:CourseDetailsViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_course)
        initRegisterCourse()
        viewModle=ViewModelProvider(this)[CourseDetailsViewModel::class.java]
        loadingDialog= LoadingDialog(this)
        val courseIntent=intent
        val courseName=courseIntent.getStringExtra("courseName")
        tvCourseName.text= courseName
        btnConfirm.setOnClickListener{
            var validUserInfo: Boolean = false

            // check validations
            validUserInfo = validateInputs(etEmail.text.toString())
            if(validUserInfo)
            {
//                Toast.makeText(this,"Confirmation Mail is Sent to You",Toast.LENGTH_LONG).show()
            loadingDialog.startLoadingDialog()
         viewModle.courseRegister("b8b118e0-ddd3-49fd-93ee-e3b5193b5694",2)

                viewModle.courseRegisterLiveData.observe(this,{
                    if(it!=null){
                        if(!it){
                            showErrorDialog()
                        }else{
                            viewModle.sendEmail(etEmail.text.toString(),tvCourseName.text.toString())
                        }
                        loadingDialog.dismissDialog()
                    }
                    viewModle.cleaRegisterData()
                })

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


    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this@RegisterCourse)
        builder.setMessage("You Can't Register This Course")
            .setNegativeButton(
                "Ok"
            ) { dialog, id -> dialog.cancel() }
        val alertDialog = builder.create()
        alertDialog.setOnShowListener{
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE)
        }

        alertDialog.show()

    }
}