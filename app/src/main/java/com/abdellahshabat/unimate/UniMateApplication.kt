package com.abdellahshabat.unimate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application entry point.
 * Hilt starts dependency injection from here.
 */
//@HiltAndroidApp هو الذي يخبر Hilt أن هذا هو تطبيقك. بدونه لن يعمل Hilt إطلاقًا.
@HiltAndroidApp
class UniMateApplication : Application()