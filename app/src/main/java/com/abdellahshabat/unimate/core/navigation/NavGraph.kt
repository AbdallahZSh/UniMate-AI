package com.abdellahshabat.unimate.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdellahshabat.unimate.feature.auth.presentation.LoginScreen
import com.abdellahshabat.unimate.feature.auth.presentation.register.RegisterScreen
import com.abdellahshabat.unimate.feature.home.presentation.HomeScreen
import com.abdellahshabat.unimate.feature.onboarding.presentation.OnBoardingScreen
import com.abdellahshabat.unimate.feature.splash.presentation.SplashScreen

@Composable
fun NavGraph() {
    //rememberNavController ينشئ كائنًا مسؤولًا عن التنقل بين الشاشات.تخيله كأنه سائق ينقل المستخدم من شاشة إلى أخرى.
    val navController = rememberNavController() //العقل المدبر

    //NavHost(...) هو الحاوية التي تحتوي جميع الشاشات. كل شاشة نضيفها لاحقًا ستكون داخل هذا الجزء.
    NavHost(
        navController = navController,
        //startDestination هذه هي أول شاشة تظهر عند تشغيل التطبيق.
        startDestination = Screen.Splash.route
    ) {
        //composable  كل شاشة في التطبيق يجب تسجيلها هنا.
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController)
        }
        composable(Routes.Login) {
            LoginScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Register.route) {
            RegisterScreen()
        }

    }
}