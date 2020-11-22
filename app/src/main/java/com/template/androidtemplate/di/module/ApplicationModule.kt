package com.template.androidtemplate.di.module

import android.app.Application
import android.content.Context
import com.template.androidtemplate.BuildConfig
import com.template.androidtemplate.data.api.ApiHelper
import com.template.androidtemplate.data.api.ApiHelperImpl
import com.template.androidtemplate.data.api.ApiService
import com.template.androidtemplate.data.helper.AppPreferenceHelperImpl
import com.template.androidtemplate.data.helper.PreferencesHelper
import com.template.androidtemplate.di.PreferenceInfo
import com.template.androidtemplate.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {


    @Provides
    @Singleton
    fun provideContext(application: Application?): Context? {
        return application
    }

    @Provides
    fun providesBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper


    @Provides
    @PreferenceInfo
    fun providePreferenceName() = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferencesHelper(preferencesHelper: AppPreferenceHelperImpl): PreferencesHelper = preferencesHelper

}
