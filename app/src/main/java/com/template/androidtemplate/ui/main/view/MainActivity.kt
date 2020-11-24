package com.template.androidtemplate.ui.main.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.template.androidtemplate.R
import com.template.androidtemplate.ui.main.viewmodel.MainViewModel
import com.template.androidtemplate.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerViewCategory: RecyclerView
    private lateinit var recyclerViewHome: RecyclerView
    private lateinit var categoryAdapter: CategoryRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
        initializeViews()
        doObserveWork()
    }

    private fun setUpViews() {

        progressBar = findViewById(R.id.progressBarHome)
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory)
        recyclerViewHome = findViewById(R.id.recyclerViewHome)

    }

    private fun initializeViews() {

        recyclerViewCategory.layoutManager = LinearLayoutManager(this)
        categoryAdapter = CategoryRe(arrayListOf())
        recyclerViewCategory.addItemDecoration(
            DividerItemDecoration(
                recyclerViewCategory.context,
                (recyclerViewCategory.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerViewCategory.adapter = categoryAdapter

    }

    @SuppressLint("SetTextI18n")
    private fun doObserveWork() {

        mainViewModel.getUserDetails().observe(this, Observer {

            name.text = it.userDetails.firstName
            emailAddress.text = it.userDetails.email
            Glide.with(profileImage.context).load(it.userDetails.image).into(profileImage)

        })

        mainViewModel.getHomeFeeds().observe(this, Observer {

            when(it.status){

                Status.SUCCESS ->{

                    progressBar.visibility = View.GONE

                }

                Status.ERROR ->{

                }
                Status.LOADING ->{

                }
            }

        })

    }

    private fun renderCategories(){
        categoryAdapter.addD
    }


}