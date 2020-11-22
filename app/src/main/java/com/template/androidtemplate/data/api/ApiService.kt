package com.template.androidtemplate.data.api

import com.template.androidtemplate.data.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST(ApiEndPoints.LOGIN)
    @FormUrlEncoded
    suspend fun userLogin(
        @Field("username") userEmail: String,
        @Field("password") userPassword: String
    ): Response<User>


    //    private static final String BASE_URL = "http://api.searchsolutionspl.com/api/";
// @POST("login")
//    @FormUrlEncoded
//    Observable<UserLogin> login(
//            @Field("username") String email,
//            @Field("password") String password
//    );
}