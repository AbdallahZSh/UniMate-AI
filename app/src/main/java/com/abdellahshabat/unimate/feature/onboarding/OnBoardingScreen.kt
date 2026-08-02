package com.abdellahshabat.unimate.feature.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//OnBoardingScreen لأن الـ Navigation لا يستطيع الانتقال إلى شاشة غير موجودة.
@Composable
fun OnBoardingScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "OnBoarding Screen",
            style = MaterialTheme.typography.headlineMedium
        )

    }
}