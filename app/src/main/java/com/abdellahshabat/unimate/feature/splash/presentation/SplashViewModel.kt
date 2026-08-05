package com.abdellahshabat.unimate.feature.splash.presentation
/**
 * ViewModel responsible for Splash screen logic.
 * يعني أن هذا الكلاس سيعيش مع الشاشة ويحفظ حالتها.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.core.datastore.PreferenceRepository
import com.abdellahshabat.unimate.core.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: PreferenceRepository
) : ViewModel(){

    private val _startDestination =
        MutableStateFlow(Routes.OnBoarding)
    val startDestination: StateFlow<String> = _startDestination

    init {
        checkOnBoardingState()
    }

    private fun checkOnBoardingState() {

        viewModelScope.launch {

            repository.onboardingCompleted.collect { completed ->

                _startDestination.value =
                    if (completed)
                        Routes.Login
                    else
                        Routes.OnBoarding

            }

        }

    }

}