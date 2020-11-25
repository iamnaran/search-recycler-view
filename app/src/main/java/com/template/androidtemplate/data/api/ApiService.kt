package com.template.androidtemplate.data.api

import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.data.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(ApiEndPoints.LOGIN)
    @FormUrlEncoded
    suspend fun userLogin(
        @Field("email") userEmail: String,
        @Field("password") userPassword: String
    ): Response<User>

    @GET(ApiEndPoints.HOME)
    suspend fun homeFeeds(): Response<Home>


}