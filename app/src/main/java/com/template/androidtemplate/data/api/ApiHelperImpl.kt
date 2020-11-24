package com.template.androidtemplate.data.api

import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun postLogin(email: String, password: String): Response<User> = apiService.userLogin(email,password)
    override suspend fun homeFeeds(): Response<Home> = apiService.homeFeeds()

}