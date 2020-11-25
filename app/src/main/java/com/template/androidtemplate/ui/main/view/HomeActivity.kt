package com.template.androidtemplate.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.template.androidtemplate.R
import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.ui.main.adapter.CategoryAdapter
import com.template.androidtemplate.ui.main.viewmodel.MainViewModel
import com.template.androidtemplate.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpViews()
        doObserveWork()
    }


    private fun setUpViews() {

        recyclerViewCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        categoryAdapter = CategoryAdapter(arrayListOf())
        recyclerViewCategory.adapter = categoryAdapter

    }

    private fun doObserveWork() {

        progressBarHome.visibility = View.VISIBLE

        mainViewModel.progressBarVisibility.observe(this, Observer {

        })

        mainViewModel.getUserDetails().observe(this, Observer {

            name.text = it.userDetails.firstName
            emailAddress.text = it.userDetails.email
            Glide.with(profileImage.context).load(it.userDetails.image).into(profileImage)

        })

        mainViewModel.getHomeFeeds().observe(this, Observer {

            when (it.status) {

                Status.SUCCESS -> {

                    progressBarHome.visibility = View.INVISIBLE

                    val gson: Gson = Gson()
                    Log.e( "doObserveWork: ",gson.toJson(it.data!!.categoriesList) )

                    renderHomeList(it.data.categoriesList)


                }

                Status.ERROR -> {
                    progressBarHome.visibility = View.INVISIBLE


                }

                Status.LOADING -> {


                }


            }

        })

        }

    private fun renderHomeList(categoriesList: List<Home.Categories>) {

        categoryAdapter.addData(categoriesList)
        categoryAdapter.notifyDataSetChanged()

    }

}