package com.template.androidtemplate.ui.main.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.ui.login.viewmodel.LoginViewModel
import com.template.androidtemplate.utils.NetworkHelper
import com.template.androidtemplate.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val networkHelper: NetworkHelper,
    private val preferencesHelper: PreferencesHelper
) : ViewModel() {
    private val TAG = MainViewModel::class.qualifiedName

    var userDetails: MutableLiveData<User> = MutableLiveData()

    fun getUserDetails(): LiveData<User> {

        return userDetails
    }

    init {

        setUpLoggedInUserDetails();

    }

    private fun setUpLoggedInUserDetails() {


        viewModelScope.launch {

            userDetails.postValue(preferencesHelper.getUserLoginDetails())


        }

    }


}