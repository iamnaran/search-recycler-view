package com.template.androidtemplate.data.api

import android.content.Context
import com.template.androidtemplate.utils.AppConstants
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.internal.ignoreIoExceptions
import okio.IOException
import javax.inject.Inject

class SupportAuthenticator @Inject constructor(context: Context): Authenticator {

    private var appContext: Context? = null

    init {
        appContext = context
    }

    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {
        var requestAvailable: Request? = null
        try {
            requestAvailable = response.request.newBuilder()
                .addHeader("token", appContext!!.getSharedPreferences(AppConstants.PREF_KEY_ACCESS_TOKEN, Context.MODE_PRIVATE).toString())
                .build()
            return requestAvailable
        } catch (ex: Exception) {
            ignoreIoExceptions {  }
        }
        return requestAvailable

    }
}