package com.example.domain

import androidx.annotation.StringRes

interface SharedPrefsManager {

    fun saveString(@StringRes key: Int, value: String?)

    fun saveString(key: String, value: String?)

    fun saveBoolean(@StringRes key: Int, value: Boolean)

    fun saveInt(@StringRes key: Int, value: Int)

    fun saveLong(@StringRes key: Int, value: Long)

    fun get(@StringRes key: Int): String?

    fun getOrNull(key: String): String?

    fun get(@StringRes key: Int, defaultValue: String): String

    fun get(key: String, defaultValue: String): String

    fun getBoolean(@StringRes key: Int, defaultValue: Boolean): Boolean

    fun getInt(@StringRes key: Int, defaultValue: Int): Int

    fun getInt(key: String, defaultValue: Int): Int?

    fun getLong(@StringRes key: Int, defaultValue: Long): Long

    fun remove(key: String)

    fun contains(@StringRes key: Int): Boolean
}
