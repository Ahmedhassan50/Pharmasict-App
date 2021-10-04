package com.example.pharmasictapp.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.util.Patterns
import android.view.View
import android.widget.*

import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.pharmasictapp.R


class SignUpActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var userName: EditText? = null
    var email: EditText? = null
    var password: EditText?=null
    var confirmPassword: EditText?=null
    var mobileNumber: EditText?=null
    lateinit var pharmcyName: EditText
    lateinit var pharmacyArea: EditText
    lateinit var ParentpharmcyName: EditText
    var isPharmcist :Boolean = false
    var isPharmcistOwner :Boolean = false

    constructor(parcel: Parcel) : this() {

    }
// Create an ArrayAdapter using the string array and a default spinner layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
         val spinner = findViewById<Spinner>(R.id.occuption_spinner)
        email = findViewById(R.id.et_signup_email)
        userName = findViewById(R.id.et_signup_username)
        password=findViewById(R.id.et_signup_password)
        confirmPassword=findViewById(R.id.et_signup_confirmpassword)
        mobileNumber=findViewById(R.id.et_signup_mobilenumber)
        ArrayAdapter.createFromResource(this, R.array.occupation_array,android.R.layout.simple_spinner_item).also{
            adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
        initSignUpButton()
    }

    private fun initSignUpButton() {
        val SignUpBtn = findViewById<Button>(R.id.btn_signup_signupBtn)

        SignUpBtn.setOnClickListener {
            val usernameText = userName?.text.toString().trim()
            val emailText =email?.text.toString().trim()
            val passwordText = password?.text.toString()
            val confirmPasswordText = confirmPassword?.text.toString()
            val mobileText = mobileNumber?.text.toString()
            val pharamcyNAMETEXT = pharmcyName?.text.toString()
            val pharmAreaText =pharmacyArea?.text.toString()
            when {
                usernameText.isEmpty() -> Toast.makeText(
                    this,
                    "userName cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
                emailText.isEmpty() -> Toast.makeText(
                    this,
                    "email cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
                mobileText.isEmpty() -> Toast.makeText(
                    this,
                    "mobile cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
                passwordText.isEmpty() -> Toast.makeText(
                    this,
                    "password cannot be empty",
                    Toast.LENGTH_LONG
                ).show()
                passwordText.equals(confirmPasswordText)   -> {
                    password?.error = "password doesn't match"
                    Toast.makeText(
                        this,
                        "password doesn't match",
                        Toast.LENGTH_LONG
                    ).show()
                }

                Patterns.EMAIL_ADDRESS.matcher(emailText).matches().not() -> {
                    email?.error = "Enter valid email"
                    Toast.makeText(this, "Enter a valid email", Toast.LENGTH_LONG)
                        .show()
                }
                passwordText.length <8 -> {
                    password?.error = "password cannot be less than 8"
                    Toast.makeText(
                    this,
                    "password cannot be less than 8",
                    Toast.LENGTH_LONG
                ).show()}
                isPharmcistOwner &&pharamcyNAMETEXT.isEmpty() ->{
                    pharmcyName?.error="Pharmcy Name can't be empty "
                    Toast.makeText(
                        this,
                        "Pharmcy Name can't be empty",
                        Toast.LENGTH_LONG
                    ).show()
                }
                isPharmcistOwner &&pharmAreaText.isEmpty() ->{
                    pharmacyArea?.error="Pharmcy Area can't be empty "
                    Toast.makeText(
                        this,
                        "Pharmcy Area can't be empty",
                        Toast.LENGTH_LONG
                    ).show()
                }
                mobileText.length <11 -> {
                    mobileNumber?.error="Mobile number can't be less than 11"
                    Toast.makeText(
                    this,
                    "Mobile number can't be less than 11",
                    Toast.LENGTH_LONG
                ).show()}
                else -> {
                    userName?.error = null
                    password?.error = null
                    mobileNumber?.error=null

                    Toast.makeText(
                        this,
                        "Signed up",
                        Toast.LENGTH_LONG
                    ).show()


                }

            }
        }
    }

    override fun onItemSelected(spinner: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val selectedItem: String = spinner?.getSelectedItem().toString()
        if(selectedItem=="Pharmacist" || selectedItem=="Pharmacist Owner"){

            pharmcyName=findViewById(R.id.et_signup_pharmacyName)
            pharmcyName.setVisibility(View.VISIBLE);

            pharmacyArea=findViewById(R.id.et_signup_PharmcyArea)
            pharmacyArea.setVisibility(View.VISIBLE);
            if(selectedItem=="Pharmacist"){
                isPharmcist=true
            }else{isPharmcistOwner=true}
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}




