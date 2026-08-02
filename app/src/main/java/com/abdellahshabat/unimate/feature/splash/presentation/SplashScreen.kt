package com.abdellahshabat.unimate.feature.splash.presentation
//لماذا لا نضع المنطق داخل SplashScreen؟
//
//لأن شاشة Compose يجب أن تكون مسؤولة عن الرسم فقط.
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier  //Modifier هو الوسيلة التي نتحكم بها في شكل العنصر وسلوكه.
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abdellahshabat.unimate.core.navigation.Screen
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(navController: NavHostController) {

    val viewModel: SplashViewModel = viewModel()
    //تشغّل الكود مرة واحدة فقط عند ظهور الشاشة. LaunchedEffect
    //onCreate()  تشبه:
    LaunchedEffect(Unit) {

        delay(2000) //انتظر ثانيتين.

        navController.navigate(Screen.OnBoarding.route) { //انتقل إلى الشاشة التالية.

            popUpTo(Screen.Splash.route) {
                inclusive = true  //احذف شاشة Splash نفسها أيضًا.
            }
            //popUpTo(...)
            //هذه من أهم أوامر Navigation.
            //بدونها سيكون الـ Back Stack:
            //Splash
            //OnBoarding
            //وعند الضغط على زر الرجوع:
            //⬅️ سيعود إلى Splash.
            //أما باستخدام:
            //popUpTo(...)
            //سيصبح:
            //OnBoarding
            //فقط.
            //أي أن Splash تُحذف من الذاكرة.
            //لو كانت:
            //false
            //فستبقى داخل الـ Back Stack.
        }

    }
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

    }
}
//Thread.sleep(2000) ❌ هذه طريقة خاطئة.
//لأنها توقف الـ UI بالكامل لمدة ثانيتين، ولن يستطيع النظام رسم الشاشة أو التفاعل مع المستخدم.
//في Compose نستخدم Coroutine مع:
//وهذا ينتظر بدون تجميد واجهة المستخدم.delay()