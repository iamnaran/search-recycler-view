package com.template.androidtemplate.utils

class AppConstants {

    companion object{

        const val PREF_NAME = "app_preference"
        const val NULL_INDEX = -1L

        const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        const val PREF_KEY_CURRENT_USER_DETAILS = "PREF_KEY_CURRENT_USER_DETAILS"
        const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        const val PREF_KEY_HOME_FEEDS = "PREF_KEY_HOME_FEEDS"


    }



    enum class LoggedInMode(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);
    }
}

