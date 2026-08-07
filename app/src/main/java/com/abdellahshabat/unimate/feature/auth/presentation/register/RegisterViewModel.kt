package com.abdellahshabat.unimate.feature.auth.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.feature.auth.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())

    val state: StateFlow<RegisterState> = _state

    fun onEmailChange(email: String) {
        _state.value = _state.value.copy(
            email = email,
            error = null
        )
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(
            password = password,
            error = null
        )
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _state.value = _state.value.copy(
            confirmPassword = confirmPassword,
            error = null
        )
    }

    fun register() {

        val currentState = _state.value

        //isBlank() هي دالة جاهزة في Kotlin لفحص هل النص فارغ أو يحتوي فقط على مسافات.
        if (currentState.email.isBlank()) {
            _state.value = currentState.copy(
                error = "Please enter your email"
            )
            return
        }

        if (currentState.password.isBlank()) {
            _state.value = currentState.copy(
                error = "Please enter your password"
            )
            return
        }

        if (currentState.password != currentState.confirmPassword) {
            _state.value = currentState.copy(
                error = "Passwords do not match"
            )
            return
        }

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            val result = repository.register(
                email = currentState.email,
                password = currentState.password
            )

            _state.value = if (result.isSuccess) {

                _state.value.copy(
                    isLoading = false,
                    success = true
                )

            } else {

                _state.value.copy(
                    isLoading = false,
                    error = result.exceptionOrNull()?.message
                        ?: "Registration failed"
                )
            }
        }
    }
}