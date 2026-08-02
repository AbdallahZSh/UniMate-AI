package com.abdellahshabat.unimate.feature.onboarding.model

import com.abdellahshabat.unimate.R

/**
 * Contains all onboarding pages displayed to the user.
 */
val onBoardingPages = listOf(

    //يمثل: 🎓 التعليم والجامعة.
    OnBoardingPage(
        title = "Welcome to UniMate AI",
        description = "Your smart assistant for university life.",
        imageRes = R.drawable.onboarding_1
    ),
    //يمثل: 🤖 الذكاء الاصطناعي والمساعد الذكي.
    OnBoardingPage(
        title = "AI-Powered Learning",
        description = "Ask AI questions, summarize lectures, and learn faster.",
        imageRes = R.drawable.onboarding_2
    ),
    //يمثل : 📚 تنظيم الدراسة والمواد.
    OnBoardingPage(
        title = "Stay Organized",
        description = "Manage courses, assignments, notes, and files in one place.",
        imageRes = R.drawable.onboarding_3
    )

)