package com.abdellahshabat.unimate.feature.auth.presentation.login


data class LoginState(

    val isLoading:Boolean = false,

    val error:String? = null,

    val success:Boolean = false

)