package com.template.androidtemplate.ui.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.template.androidtemplate.ui.photos.view.PhotosActivity
import com.template.androidtemplate.ui.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity(){

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_splash);
        splashViewModel.checkLoggedInMode()
        observeLoggedInMode();

    }

    private fun observeLoggedInMode() {

        splashViewModel.isUserLoggedIn().observe(this, Observer {
            if (it){
                startActivity(Intent(this, PhotosActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, PhotosActivity::class.java))
                finish()
            }

        })

    }

}