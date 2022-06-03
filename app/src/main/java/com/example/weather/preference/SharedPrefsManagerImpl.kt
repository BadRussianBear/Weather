package com.example.weather.preference

import android.content.Context
import androidx.annotation.NonNull
import androidx.annotation.StringRes
import com.example.domain.SharedPrefsManager
import com.example.domain.di.AppContext
import javax.inject.Inject

class SharedPrefsManagerImpl @Inject constructor(
    @AppContext private val context: Context
) : SharedPrefsManager {

    private var sharedPrefs = context.getSharedPreferences(WEATHER, Context.MODE_PRIVATE)
    private var prefsEditor = sharedPrefs.edit()

    private fun getKey(@StringRes key: Int): String = context.getString(key)

    override fun saveString(@StringRes key: Int, value: String?) {
        prefsEditor.putString(getKey(key), value)
        prefsEditor.commit()
    }

    override fun saveString(key: String, value: String?) {
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    override fun getOrNull(key: String): String? {
        return sharedPrefs.getString(key, null)
    }

    override operator fun get(key: String, @NonNull defaultValue: String): String {
        return sharedPrefs.getString(key, defaultValue) ?: ""
    }

    override fun saveBoolean(@StringRes key: Int, value: Boolean) {
        prefsEditor.putBoolean(getKey(key), value)
        prefsEditor.commit()
    }

    override fun saveInt(@StringRes key: Int, value: Int) {
        prefsEditor.putInt(getKey(key), value)
        prefsEditor.commit()
    }

    override fun saveLong(@StringRes key: Int, value: Long) {
        prefsEditor.putLong(getKey(key), value)
        prefsEditor.commit()
    }

    override operator fun get(@StringRes key: Int): String? {
        return sharedPrefs.getString(getKey(key), null)
    }

    override operator fun get(@StringRes key: Int, @NonNull defaultValue: String): String {
        return sharedPrefs.getString(getKey(key), defaultValue) ?: ""
    }

    override fun getBoolean(@StringRes key: Int, defaultValue: Boolean): Boolean {
        return sharedPrefs.getBoolean(getKey(key), defaultValue)
    }

    override fun getInt(@StringRes key: Int, defaultValue: Int): Int {
        return sharedPrefs.getInt(getKey(key), defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPrefs.getInt(key, defaultValue)
    }

    override fun getLong(@StringRes key: Int, defaultValue: Long): Long {
        return sharedPrefs.getLong(getKey(key), defaultValue)
    }

    override fun remove(key: String) {
        sharedPrefs.edit()
            .remove(key)
            .apply()
    }

    override fun contains(key: Int): Boolean {
        return sharedPrefs.contains(getKey(key))
    }

    companion object {
        private const val WEATHER = "weather"
    }
}