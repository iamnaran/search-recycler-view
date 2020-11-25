package com.template.androidtemplate.data.api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.di.PreferenceInfo
import com.template.androidtemplate.utils.AppConstants
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.internal.ignoreIoExceptions
import okio.IOException
import javax.inject.Inject

class SupportAuthenticator @Inject constructor(
    private  val preferencesHelper: PreferencesHelper
) :
    Authenticator {
    var mCounter: Int = 0

    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {

        if (mCounter++ > 0) {

            return null
        }

        var requestAvailable: Request? = null

        try {
            requestAvailable = response.request.newBuilder()
                .addHeader(
                    "Authorization", preferencesHelper.getAccessToken()!!
                )
                .build()
            return requestAvailable
        } catch (ex: Exception) {
            ignoreIoExceptions { }
        }
        return requestAvailable

    }
}