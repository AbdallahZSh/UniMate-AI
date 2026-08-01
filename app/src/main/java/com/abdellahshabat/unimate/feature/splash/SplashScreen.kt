package com.abdellahshabat.unimate.feature.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable //هذه الـ Annotation تخبر Compose أن الدالة مسؤولة عن رسم واجهة المستخدم. لن يعتبر Compose الدالة شاشة أو عنصر واجهة.
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier  //Modifier هو الوسيلة التي نتحكم بها في شكل العنصر وسلوكه.

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "UniMate AI",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Your Smart University Assistant",
            style = MaterialTheme.typography.bodyLarge
        )

    }
}