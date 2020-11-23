package com.template.androidtemplate.ui.main.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.template.androidtemplate.R
import com.template.androidtemplate.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doObserveWork();
    }

    @SuppressLint("SetTextI18n")
    private fun doObserveWork() {

        mainViewModel.getUserDetails().observe(this, Observer {

            name.text = it.responseData.firstname+ " "+it.responseData.lastname
            emailAddress.text = it.responseData.email
            Glide.with(profileImage.context).load(it.responseData.imageList.large).into(profileImage)


        })

    }
}