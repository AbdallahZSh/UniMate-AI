package com.abdellahshabat.unimate.feature.auth.presentation.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.feature.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(

    private val repository: AuthRepository

): ViewModel(){
    private val _state = MutableStateFlow(LoginState())

    val state:StateFlow<LoginState> = _state

    fun login(
        email:String,
        password:String
    ){

        viewModelScope.launch {

            _state.value = LoginState(isLoading = true)

            val result = repository.login(email, password)

            _state.value = if(result.isSuccess){

                    LoginState(success = true)

                }else{

                    LoginState(error = result.exceptionOrNull()?.message)

                }

        }

    }

}