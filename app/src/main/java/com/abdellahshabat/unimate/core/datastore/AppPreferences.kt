package com.abdellahshabat.unimate.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

//preferencesDataStore() ينشئ ملفًا داخل الهاتف.
//سيصبح تقريبًا: unimate_preferences.preferences_pb
//وسيخزن جميع إعدادات التطبيق.
val Context.dataStore by preferencesDataStore(
    name = "unimate_preferences"
)

object AppPreferences {

    val ONBOARDING_COMPLETED =
        booleanPreferencesKey("onboarding_completed")

}