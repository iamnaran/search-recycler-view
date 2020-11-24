package com.template.androidtemplate.data.api

import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun postLogin(email: String,password: String): Response<User>

    suspend fun homeFeeds(): Response<Home>
}