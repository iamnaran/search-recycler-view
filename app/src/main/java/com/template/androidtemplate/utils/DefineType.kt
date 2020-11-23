package com.template.androidtemplate.utils

object DefineType {

    fun <T> getType(type: Any?, classes: Class<T>): T? {
        return try {
            classes.cast(type)
        } catch (ex: ClassCastException) {
            null
        }
    }
}