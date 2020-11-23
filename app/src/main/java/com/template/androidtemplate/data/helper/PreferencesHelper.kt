package com.template.androidtemplate.data.helper

import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.utils.AppConstants

interface PreferencesHelper {

    fun setCurrentUserLoggedInMode(loggedInMode: AppConstants.LoggedInMode)
    fun getCurrentUserLoggedInMode(): Int?

    fun getUserLoginDetails(): User?
    fun setUserLoginDetails(user: User?)

    fun getAccessToken(): String?
    fun setAccessToken(accessToken: String?)

}