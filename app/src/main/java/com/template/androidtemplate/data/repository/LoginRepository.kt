package com.template.androidtemplate.data.repository

import com.template.androidtemplate.data.api.ApiHelper
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun postLogin(email: String, password: String) = apiHelper.postLogin(email,password)

}