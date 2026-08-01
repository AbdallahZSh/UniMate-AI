package com.abdellahshabat.unimate.feature.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable //هذه الـ Annotation تخبر Compose أن الدالة مسؤولة عن رسم واجهة المستخدم. لن يعتبر Compose الدالة شاشة أو عنصر واجهة.
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier  //Modifier هو الوسيلة التي نتحكم بها في شكل العنصر وسلوكه.
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.School,
            contentDescription = "App Logo"
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "UniMate AI",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your Smart University Assistant",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        CircularProgressIndicator()

        Text(
            text = "\n\n\nWelcome to Abdellah",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "\nLoading...",
            style = MaterialTheme.typography.bodyLarge
        )

    }
}