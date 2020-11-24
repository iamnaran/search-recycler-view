package com.template.androidtemplate.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.data.repository.HomeRepository
import com.template.androidtemplate.ui.login.viewmodel.LoginViewModel
import com.template.androidtemplate.utils.NetworkHelper
import com.template.androidtemplate.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val networkHelper: NetworkHelper,
    private val preferencesHelper: PreferencesHelper,
    private val homeRepository: HomeRepository

) : ViewModel() {

    private val TAG = MainViewModel::class.qualifiedName

    var userDetails: MutableLiveData<User> = MutableLiveData()
    var progressBarVisibility: MutableLiveData<Boolean> = MutableLiveData()
    var onResponse: MutableLiveData<Resource<Home>> = MutableLiveData()


    fun isProgressBarVisible(): LiveData<Boolean> {
        return progressBarVisibility
    }

    fun getUserDetails(): LiveData<User> {
        return userDetails
    }

    fun getHomeFeeds(): LiveData<Resource<Home>>{
        return onResponse
    }

    init {
        setUpLoggedInUserDetails();
    }

    private fun setUpLoggedInUserDetails() {


        viewModelScope.launch {

            userDetails.postValue(preferencesHelper.getUserLoginDetails())

            if (preferencesHelper.getHomeFeeds() != null){
                onResponse.postValue(Resource.success(preferencesHelper.getHomeFeeds()))
            }

            if (networkHelper.isNetworkConnected()){
                homeRepository.homeFeeds().let {
                    if (it.isSuccessful){
                        onResponse.postValue(Resource.success(it.body()))
                        preferencesHelper.setHomeFeeds(it.body())
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