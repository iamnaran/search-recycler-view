package com.template.androidtemplate.data.helper

import android.content.Context
import android.content.SharedPreferences
import com.template.androidtemplate.data.model.User
import com.template.androidtemplate.di.PreferenceInfo
import com.template.androidtemplate.utils.AppConstants
import javax.inject.Inject

class AppPreferenceHelperImpl @Inject constructor(

    context: Context,
    @PreferenceInfo private val preferenceName: String

) : PreferencesHelper {

    private var mPrefs: SharedPreferences? = null
    init {
        mPrefs = context.getSharedPreferences(
            preferenceName,
            Context.MODE_PRIVATE
        )
    }

    private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
    private val PREF_KEY_CURRENT_USER_DETAILS = "PREF_KEY_CURRENT_USER_DETAILS"
    private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

    override fun setCurrentUserLoggedInMode(loggedInMode: AppConstants.LoggedInMode) {

        mPrefs!!.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, loggedInMode.type).apply()

    }

    override fun getCurrentUserLoggedInMode(): Int {
        return mPrefs!!.getInt(
            PREF_KEY_USER_LOGGED_IN_MODE,
            AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
        )

    }

    override fun getUserLoginDetails(): User? {
        TODO("Not yet implemented")
    }

    override fun setUserLoginDetails(user: User) {
        TODO("Not yet implemented")
    }

    override fun getAccessToken(): String? {
        TODO("Not yet implemented")
    }

    override fun setAccessToken(accessToken: String?) {
        TODO("Not yet implemented")
    }


}