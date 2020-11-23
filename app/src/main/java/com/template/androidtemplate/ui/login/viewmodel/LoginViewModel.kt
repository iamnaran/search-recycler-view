package com.template.androidtemplate.ui.login.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.data.repository.LoginRepository
import com.template.androidtemplate.utils.AppConstants
import com.template.androidtemplate.utils.NetworkHelper
import com.template.androidtemplate.utils.Resource
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val networkHelper: NetworkHelper,
    private val preferencesHelper: PreferencesHelper,
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val TAG = LoginViewModel::class.qualifiedName

    var progressBarVisibility: MutableLiveData<Boolean> = MutableLiveData()

    var onResponse: MutableLiveData<Resource<User>> = MutableLiveData()


    fun isProgressBarVisible(): LiveData<Boolean> {
        return progressBarVisibility
    }

    fun onResponse(): LiveData<Resource<User>> {
        return onResponse
    }


    fun doLoginWork(email: String?, password: String?) {


        if (isEmailPasswordEmpty(email, password)) {

            progressBarVisibility.postValue(false)

        } else {


            viewModelScope.launch {

                if (networkHelper.isNetworkConnected()) {

                    if (preferencesHelper.getUserLoginDetails() != null){

                        Log.e(TAG, "doLoginWork: preference Not null" )

                    }else{
                        Log.e(TAG, "doLoginWork: null" )

                    }

                    loginRepository.postLogin(email!!, password!!).let {
                        if (it.isSuccessful){
                            onResponse.postValue(Resource.success(it.body()))
                            preferencesHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                            preferencesHelper.setUserLoginDetails(it.body())
                        }else{
                            onResponse.postValue(Resource.error(it.errorBody().toString(),null))
                        }
                    }
                }else{


                }

                }

        }


    }

    private fun isEmailPasswordEmpty(
        email: String?,
        password: String?
    ): Boolean {
        // validate email and password
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return true
        }
        return false
    }


}