package com.cartenz.kotlin_core.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.text.TextUtils

public class PrefHelper {
    companion object {
        fun getPref(context: Context): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun saveToPref(context: Context, key: String, `val`: String) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, `val`).apply()
        }

        fun clearAll(context: Context) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().clear().apply()

        }

        fun remove(context: Context, key: String) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(key).apply()

        }

        fun getPref(context: Context, key: String): String? {
            return if (PreferenceManager.getDefaultSharedPreferences(context).contains(key)) {
                PreferenceManager.getDefaultSharedPreferences(context).getString(key, null)
            } else {
                null
            }

        }

        fun isPrefNotEmpty(context: Context, string: String): Boolean {
            return !TextUtils.isEmpty(getPref(context).getString(string, null))
        }
    }

}