package com.abdellahshabat.unimate.feature.auth.presentation.register


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun RegisterScreen(

    viewModel: RegisterViewModel = hiltViewModel()

){


    val state by viewModel.state.collectAsState()



    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {



        Text(

            text = "Create Account",

            style = MaterialTheme.typography.headlineMedium

        )



        Spacer(
            modifier = Modifier.height(32.dp)
        )



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
                    contentDescription = null
                )

            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )

        )



        Spacer(
            modifier = Modifier.height(16.dp)
        )



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
                    contentDescription = null
                )

            },


            visualTransformation =
                PasswordVisualTransformation()

        )



        Spacer(
            modifier = Modifier.height(16.dp)
        )



        OutlinedTextField(

            value = state.confirmPassword,

            onValueChange = {

                viewModel.onConfirmPasswordChange(it)

            },


            label = {

                Text("Confirm Password")

            },


            leadingIcon = {

                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )

            },


            visualTransformation =
                PasswordVisualTransformation()

        )



        Spacer(
            modifier = Modifier.height(24.dp)
        )



        if(state.isLoading){


            CircularProgressIndicator()


        }else{


            Button(

                onClick = {

                    viewModel.register()

                }

            ){

                Text("Register")

            }


        }



        Spacer(
            modifier = Modifier.height(16.dp)
        )



        state.error?.let {


            Text(

                text = it,

                color = MaterialTheme.colorScheme.error

            )


        }


    }


}