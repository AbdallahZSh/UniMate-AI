package com.abdellahshabat.unimate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

//هذا يحدد ألوان التطبيق في الوضع الفاتح.lightColorScheme
private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryGreen,
    background = BackgroundLight,
    surface = SurfaceLight,
    error = Error
)

//darkColorScheme  وهذا يحدد ألوان التطبيق في الوضع الداكن.
private val DarkColors = darkColorScheme(
    primary = PrimaryBlueDark,
    secondary = SecondaryGreen,
    error = Error
)

//isSystemInDarkTheme()  يفحص إعدادات الهاتف. إذا كان المستخدم يستخدم الوضع الليلي، سيطبق الألوان الداكنة تلقائيًا.
@Composable
fun UniMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

//MaterialTheme  هذا هو قلب تصميم التطبيق.كل عناصر Compose مثل: Button, Text, Card ,NavigationBar ستستخدم هذه الألوان تلقائيًا.
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}