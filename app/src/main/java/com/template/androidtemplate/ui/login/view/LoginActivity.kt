package com.template.androidtemplate.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.template.androidtemplate.R
import com.template.androidtemplate.ui.login.viewmodel.LoginViewModel
import com.template.androidtemplate.ui.main.view.MainActivity
import com.template.androidtemplate.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var progressBar: ProgressBar

    private lateinit var buttonLogin: TextView

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpViews()
        doObserveViewsWork()
    }


    private fun setUpViews() {

        progressBar = findViewById(R.id.progressBar)
        buttonLogin = findViewById(R.id.btnLogin)
        emailEditText = findViewById(R.id.editTextEmailAddress)
        passwordEditText = findViewById(R.id.editTextPassword)

        btnLogin.setOnClickListener(this)

    }

    private fun doObserveViewsWork() {


        loginViewModel.isProgressBarVisible().observe(this, Observer<Boolean> {

            if (it == false) progressBar.visibility = View.INVISIBLE

        })

        loginViewModel.onResponse.observe(this, Observer {

            when(it.status){

                Status.SUCCESS ->{

                    val intent: Intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }

                Status.ERROR ->{

                    progressBar.visibility = View.INVISIBLE

                }

                Status.LOADING ->{

                    progressBar.visibility = View.INVISIBLE

                }

            }

        })


    }

    override fun onClick(v: View?) {

        when (v!!.id) {

            R.id.btnLogin -> {

                progressBar.visibility = View.VISIBLE

                loginViewModel.doLoginWork(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )

            }
        }
    }
}