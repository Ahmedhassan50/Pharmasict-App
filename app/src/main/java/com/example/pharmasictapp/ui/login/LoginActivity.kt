package com.example.pharmasictapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.pharmasictapp.R
import com.example.pharmasictapp.db.LoggingUserInfo
import com.example.pharmasictapp.db.network.ApiService
import com.example.pharmasictapp.db.repositories.AuthRepository
import com.example.pharmasictapp.ui.home_layout.HomeLayout
import com.example.pharmasictapp.utils.LoadingDialog
import com.example.pharmasictapp.utils.ValidUserInfo
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var etPassword: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSkip: ImageButton
    private lateinit var tvForgetPassword: TextView
    private lateinit var tvSignUp: TextView
    private lateinit var btnLogin: Button
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var serviceInstance: AuthInterface
    private lateinit var authRepository: AuthRepository
    private lateinit var loadingDialog: LoadingDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initMainActivity()
        FirebaseApp.initializeApp(this)
        firebaseAnalytics = Firebase.analytics
        serviceInstance = ApiService.getRetrofitBuilder().create(AuthInterface::class.java)
        authRepository = AuthRepository(serviceInstance)
        loadingDialog = LoadingDialog(this)



        btnLogin.setOnClickListener {
            var validCredentials: Boolean = false
            var validUserInfo: Boolean = false

            //get the inputs
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()


            // check validations
            validUserInfo = validateInputs(email, password)

            if (validUserInfo) {
                firebaseAnalytics.logEvent("login", null)
                login(email, password)
            }


        }
        btnSkip.setOnClickListener {
            firebaseAnalytics.logEvent("skipClicked", null)

            // go to home activity as a guest
            val intent: Intent = Intent(this, HomeLayout::class.java)
            startActivity(intent)


        }

        tvSignUp.setOnClickListener {
            // go to sign up activity

        }
        tvForgetPassword.setOnClickListener {
        }
    }

    @DelicateCoroutinesApi
    private fun login(email: String, password: String) {
        loadingDialog.startLoadingDialog()

        GlobalScope.launch(Dispatchers.IO) {
            val responseData = async {
                authRepository.login(email, password)
            }
            val loginResult = responseData.await()
            loadingDialog.dismissDialog()
            if (loginResult.isSuccessful) {
                if (loginResult.body()?.get("isSuccess")?.asBoolean == true) {
                    val userData = JSONObject(loginResult.body()?.get("data").toString())

                    LoggingUserInfo.setId(userData.get("id").toString())
                    LoggingUserInfo.setEmailAddress(userData.get("email").toString())
                    LoggingUserInfo.setName(userData.get("name").toString())
                    LoggingUserInfo.setPhoneNumber(userData.get("phoneNumber").toString())
                    LoggingUserInfo.setToken(userData.get("token").toString())

                    val sharedPref=getSharedPreferences("autoLogin", MODE_PRIVATE)
                    val editor=sharedPref.edit()
                    editor.putString("userData",userData.toString())
                    editor.apply()

                    // go to home activity
                    val intent: Intent = Intent(this@LoginActivity,HomeLayout::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        showErrorDialog()
                    }

                }


            } else {
                withContext(Dispatchers.Main) {
                    showErrorDialog()
                }
            }


        }
    }


    private fun validateInputs(email: String, password: String): Boolean {
        var valid = false
        var passwordValid = false
        when {
            ValidUserInfo.validEmailAddress(email) == ValidUserInfo.EMPTY -> {
                etEmail.error = "Please Enter Email Address"


            }
            ValidUserInfo.validEmailAddress(email) == ValidUserInfo.NOT_EMAIL_FORM -> {
                etEmail.error = "Not Valid Email Format"

            }
            else -> {
                etEmail.error = null
                valid = true
            }
        }
        when {
            ValidUserInfo.validPassword(password) == ValidUserInfo.EMPTY -> {
                etPassword.error = "Please Enter your Password"


            }
            ValidUserInfo.validPassword(password) == ValidUserInfo.NOT_VALID -> {
                etPassword.error = "Password must be 8 digits at least"

            }
            else -> {
                etPassword.error = null
                passwordValid = true
            }
        }

        return passwordValid && valid

    }




    private fun initMainActivity() {

        btnLogin = findViewById(R.id.btn_login_loginBtn)
        tvForgetPassword = findViewById(R.id.tv_login_forget_password)
        tvSignUp = findViewById(R.id.tv_login_signUp)
        btnSkip = findViewById(R.id.img_btn_login_skip)
        etEmail = findViewById(R.id.et_login_email)
        etPassword = findViewById(R.id.et_login_password)


    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this@LoginActivity)
        builder.setMessage("Something went wrong, please try again")
            .setNegativeButton(
                "Ok"
            ) { dialog, id -> dialog.cancel() }
        val alertDialog = builder.create()
        alertDialog.show()
    }


}