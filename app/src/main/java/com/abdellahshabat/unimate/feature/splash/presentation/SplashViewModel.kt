package com.abdellahshabat.unimate.feature.splash.presentation
/**
 * ViewModel responsible for Splash screen logic.
 * يعني أن هذا الكلاس سيعيش مع الشاشة ويحفظ حالتها.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.core.datastore.PreferenceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: PreferenceRepository
) : ViewModel() {

    private var _startDestination =
        MutableStateFlow("")

    val startDestination: StateFlow<String> =
        _startDestination

    init {
        checkOnBoardingState()
    }

    private fun checkOnBoardingState() {

        viewModelScope.launch {

            repository.onboardingCompleted.collect { completed ->

                _startDestination =
                    if (completed)
                        MutableStateFlow("login")
                    else
                        MutableStateFlow("onboarding")

            }

        }

    }

}