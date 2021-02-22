package com.template.androidtemplate.ui.photos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.data.model.Photos
import com.template.androidtemplate.data.repository.PhotosRepository
import com.template.androidtemplate.utils.NetworkHelper
import com.template.androidtemplate.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val preferencesHelper: PreferencesHelper,
    private val photosRepository: PhotosRepository

) : ViewModel() {

    private val TAG = PhotosViewModel::class.qualifiedName

    var progressBarVisibility: MutableLiveData<Boolean> = MutableLiveData()
    var onResponse: MutableLiveData<Resource<List<Photos>>> = MutableLiveData()


    fun isProgressBarVisible(): LiveData<Boolean> {
        return progressBarVisibility
    }


    fun getPhotosFeed(): LiveData<Resource<List<Photos>>>{
        return onResponse
    }

    init {
        doPhotosWork();
    }

    private fun doPhotosWork() {


        viewModelScope.launch {


            if (networkHelper.isNetworkConnected()){

                photosRepository.photosFeed().let {

                    if (it.isSuccessful){
                        onResponse.postValue(Resource.success(it.body()))
//                        preferencesHelper.setHomeFeeds(it.body())
                        progressBarVisibility.postValue(false)
                    }else{
                        onResponse.postValue(Resource.error(it.errorBody().toString(),null))
                        progressBarVisibility.postValue(false)
                    }
                }


            }




        }

    }


}