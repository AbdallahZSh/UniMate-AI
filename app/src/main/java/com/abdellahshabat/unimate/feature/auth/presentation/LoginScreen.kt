package com.abdellahshabat.unimate.feature.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.abdellahshabat.unimate.core.navigation.Routes
import com.abdellahshabat.unimate.core.navigation.Screen
import com.abdellahshabat.unimate.feature.auth.presentation.login.LoginViewModel


@Composable
fun LoginScreen(
    navController: NavHostController,

    viewModel: LoginViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    //هذا يجعل Compose يعيد رسم الشاشة عندما تتغير القيمة.
    // ,حفظ البريد الإلكتروني الذي يكتبه المستخدم
    /*المستخدم كتب:abd@gmail.com
     تتغير قيمة:email فتتحدث الواجهة.*/
//    var email by remember {
//        mutableStateOf("")
//    }
//
//
//    // حفظ كلمة المرور
//    var password by remember {
//        mutableStateOf("")
//    }


    // التحكم في إظهار أو إخفاء كلمة المرور
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(state.success) {

        if (state.success) {

            navController.navigate(Screen.Home.route) {

                popUpTo(Screen.Login.route) {
                    //حتى لا يستطيع المستخدم الضغط Back والعودة إلى Login.
                    inclusive = true
                }

            }
        }
    }
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {


        Text(text = "Welcome Back", style = MaterialTheme.typography.headlineMedium)


        Spacer(modifier = Modifier.height(32.dp))


        //2) Email Field حقل البريد
        //هو حقل Material 3 جاهز.
        //استخدمناه لأنه يعطي: Border/ Label/ Animation /دعم Compose
        OutlinedTextField(

            value = state.email,

            onValueChange = {
                viewModel.onEmailChange(it)
            },

            label = {
                Text("Email")
            },

            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )

            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )

        )


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        //3) Password Field  كلمة المرور
        //هذا الجزء: PasswordVisualTransformation() يجعل: 123456 تظهر:••••••
        OutlinedTextField(

            value = state.password,

            onValueChange = {
                viewModel.onPasswordChange(it)
            },


            label = {
                Text("Password")
            },


            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )

            },


            trailingIcon = {

                IconButton(
                    //4) زر إظهار كلمة المرور
                    //يقلب الحالة:
                    //false → true
                    //true → false
                    onClick = {
                        passwordVisible = !passwordVisible
                    }

                ) {

                    Icon(

                        imageVector =
                            if(passwordVisible)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,


                        contentDescription = "Show password"

                    )

                }

            },


            visualTransformation =
                if(passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.height(32.dp))

        if (state.isLoading) {

            CircularProgressIndicator()

        } else {

            Button(
                onClick = {
                    viewModel.login()
                }
            ) {
                Text("Login")
            }

            TextButton(
                onClick = {
                    navController.navigate(Routes.Register)
                }

            ){

                Text("Create Account")
            }
        }

        state.error?.let { error ->

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

