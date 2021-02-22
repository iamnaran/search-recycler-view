package com.template.androidtemplate.data.repository

import com.template.androidtemplate.data.api.ApiHelper
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {


    suspend fun photosFeed() = apiHelper.getPhotos()


}