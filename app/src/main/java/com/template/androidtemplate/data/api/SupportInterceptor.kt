package com.template.androidtemplate.data.api

import com.template.androidtemplate.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.Authenticator
import javax.inject.Inject

class SupportInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "Accept: application/x.school.v1+json")
            .build()
        return chain.proceed(request)
    }

}