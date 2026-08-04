package com.abdellahshabat.unimate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application entry point.
 * Hilt starts dependency injection from here.
 */
//@HiltAndroidApp
// هو الذي يخبر Hilt أن هذا هو تطبيقك. بدونه لن يعمل Hilt إطلاقًا.
//@HiltAndroidApp
//يخبر Hilt أن يبدأ إنشاء الحاوية (Dependency Container).
//بعدها يصبح بإمكان أي ViewModel أو Repository استخدام:
//@Inject
@HiltAndroidApp
class UniMateApplication : Application()