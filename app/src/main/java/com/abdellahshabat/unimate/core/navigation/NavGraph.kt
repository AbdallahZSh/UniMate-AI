package com.abdellahshabat.unimate.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdellahshabat.unimate.feature.splash.SplashScreen

@Composable
fun NavGraph() {
//rememberNavController ينشئ كائنًا مسؤولًا عن التنقل بين الشاشات.تخيله كأنه سائق ينقل المستخدم من شاشة إلى أخرى.
    val navController = rememberNavController()

    //NavHost(...) هو الحاوية التي تحتوي جميع الشاشات. كل شاشة نضيفها لاحقًا ستكون داخل هذا الجزء.
    NavHost(
        navController = navController,
        //startDestination هذه هي أول شاشة تظهر عند تشغيل التطبيق.
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen()
        }

    }
}