package com.template.androidtemplate.utils

class AppConstants {

    companion object{

        const val PREF_NAME = "app_preference"
        const val NULL_INDEX = -1L

    }

    enum class LoggedInMode(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGED_IN(1);
    }
}

