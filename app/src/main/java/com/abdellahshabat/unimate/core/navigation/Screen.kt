package com.abdellahshabat.unimate.core.navigation
//Route كل شاشة لها اسم.
//لماذا نستخدم route؟
//لأن مكتبة Navigation تعتمد على اسم لكل شاشة.
//مثلاً: Screen.Login.route
//تعطي :login
//NavHost هو الحاوية الذي يجمع جميع الشاشات.
//NavController  هو المسؤول عن التنقل.
sealed class Screen(val route: String) {

    data object Splash : Screen("splash")

    data object OnBoarding : Screen("onboarding")

    data object Login : Screen("login")

    data object Register : Screen("register")

    data object Home : Screen("home")

}