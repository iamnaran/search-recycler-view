package com.template.androidtemplate.ui.photos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.template.androidtemplate.R
import com.template.androidtemplate.data.model.Photos
import com.template.androidtemplate.ui.photos.adapter.PhotosAdapter
import com.template.androidtemplate.ui.photos.viewmodel.PhotosViewModel
import com.template.androidtemplate.utils.EmptyDataObserver
import com.template.androidtemplate.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_photos.*

@AndroidEntryPoint
class PhotosActivity : AppCompatActivity() , SearchView.OnQueryTextListener{


    private val photosViewModel: PhotosViewModel by viewModels()
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        setUpViews()
        doObserveWork()
    }


    private fun setUpViews() {

        search_layout.findViewById<SearchView>(R.id.search_view)
            .setOnQueryTextListener(this)
        recycler_view.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        photosAdapter = PhotosAdapter()
        recycler_view.adapter = photosAdapter
        val emptyDataObserver = EmptyDataObserver(recycler_view, empty_data_parent)
        photosAdapter.registerAdapterDataObserver(emptyDataObserver)

    }

    private fun doObserveWork() {


        photosViewModel.progressBarVisibility.observe(this, Observer {

        })

        photosViewModel.getPhotosFeed().observe(this, Observer {

            when (it.status) {

                Status.SUCCESS -> {


                    val gson: Gson = Gson()
                    renderPhotosList(it.data!!)


                }

                Status.ERROR -> {


                }

                Status.LOADING -> {


                }


            }

        })



    }

    private fun renderPhotosList(photosList: List<Photos>) {

        photosAdapter.addData(photosList)
        photosAdapter.notifyDataSetChanged()

    }


    override fun onQueryTextSubmit(query: String?): Boolean {

        photosAdapter.filter.filter(query)
        return false

    }

    override fun onQueryTextChange(newText: String?): Boolean {

        photosAdapter.filter.filter(newText)

        return false

    }

}