package com.example.cookit.util


import android.content.Context
import android.content.SharedPreferences

object PreferenceManager {
    private const val PREF_NAME = "CookItPrefs"

    // Keys for storing data
    private const val KEY_FIRST_TIME = "FirstTime"

    private lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // Method to check if it's the first time the app is launched
    fun isFirstTime(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_TIME, true)
    }

    // Method to set the first time flag
    fun setFirstTime(isFirstTime: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_FIRST_TIME, isFirstTime).apply()
    }
}
