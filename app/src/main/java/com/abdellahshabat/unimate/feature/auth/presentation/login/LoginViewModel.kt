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

): ViewModel() {
    private val _state = MutableStateFlow(LoginState())

    //نشأنا StateFlow<LoginState> ليحمل حالة الشاشة كاملة.
    val state: StateFlow<LoginState> = _state

    //أضفنا onEmailChange() لتحديث البريد.
    fun onEmailChange(email: String) {
        _state.value = _state.value.copy(email = email)
    }

//    أضفنا onPasswordChange() لتحديث كلمة المرور.
    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

//    أضفنا login() لاستدعاء AuthRepository والتعامل مع النجاح أو الفشل.
    fun login() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            val result = repository.login(
                _state.value.email,
                _state.value.password
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
                )
            }
        }
    }
}