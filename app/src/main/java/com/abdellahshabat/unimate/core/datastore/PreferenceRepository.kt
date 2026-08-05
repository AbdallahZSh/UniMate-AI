package com.abdellahshabat.unimate.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
//لماذا Repository؟
//حتى لا تصل الشاشة مباشرة إلى DataStore.
class PreferenceRepository @Inject constructor(

    @ApplicationContext
    private val context: Context

){
//onboardingCompleted تقرأ القيمة.
//إذا كانت: true يعني:
//لا تعرض OnBoarding.
//إذا كانت: false يعني: اعرض OnBoarding.
    val onboardingCompleted: Flow<Boolean> =
        context.dataStore.data.map { preferences ->
            preferences[AppPreferences.ONBOARDING_COMPLETED] ?: false
        }

    //عند الضغط على Get Started
    //ستصبح: onboarding_completed = true
    suspend fun saveOnBoardingState() {

        context.dataStore.edit {

            it[AppPreferences.ONBOARDING_COMPLETED] = true

        }

    }

}