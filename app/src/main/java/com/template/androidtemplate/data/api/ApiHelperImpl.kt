package com.template.androidtemplate.data.api

import com.template.androidtemplate.data.model.Home
import com.template.androidtemplate.data.model.Photos
import com.template.androidtemplate.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getPhotos(): Response<List<Photos>>  = apiService.getPhotosUrl()

}