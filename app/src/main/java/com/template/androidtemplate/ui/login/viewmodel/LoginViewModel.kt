package com.template.androidtemplate.ui.login.viewmodel

import android.text.TextUtils
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.data.repository.LoginRepository
import com.template.androidtemplate.utils.NetworkHelper
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val networkHelper: NetworkHelper,
    private val loginRepository: LoginRepository
) : ViewModel() {

    init {

    }

    private fun doLoginWork(email: String?, password: String?) {

        viewModelScope.launch {



        }
    }

    fun isEmailPasswordEmpty(
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