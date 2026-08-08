package com.abdellahshabat.unimate.feature.splash.presentation
/**
 * ViewModel responsible for Splash screen logic.
 * يعني أن هذا الكلاس سيعيش مع الشاشة ويحفظ حالتها.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.core.datastore.PreferenceRepository
import com.abdellahshabat.unimate.core.navigation.Routes
import com.abdellahshabat.unimate.feature.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: PreferenceRepository,

    private val authRepository: AuthRepository
) : ViewModel(){

    private val _startDestination =
        MutableStateFlow("")
    val startDestination: StateFlow<String> = _startDestination

    init {
        checkAppState()
    }

    private fun checkAppState(){
        viewModelScope.launch {
            repository.onboardingCompleted.collect { completed ->
                if(!completed){

                    _startDestination.value = Routes.OnBoarding

                }else{

                    _startDestination.value =

                        if(authRepository.isUserLoggedIn())

                            Routes.Main

                        else

                            Routes.Login

                }

            }

        }

    }

    private fun checkOnBoardingState() {

        viewModelScope.launch {

            repository.onboardingCompleted.collect { completed ->

                _startDestination.value =
                    if(completed)
                        Routes.Login
                    else
                        Routes.OnBoarding

            }

        }

    }

}