package com.abdellahshabat.unimate.feature.onboarding.model

/**
 * Represents a single page in the onboarding flow.
 *
 * لماذا استخدمنا Data Class؟
 * لأنها مخصصة لتخزين البيانات فقط.
 * لا تحتوي على منطق (Logic)، وإنما قيم مثل:
 * العنوان.
 * الوصف.
 * الصورة.
 */
data class OnBoardingPage(

    val title: String,

    val description: String,

    val imageRes: Int

)
/*
* تعرفت على أول Model في المشروع.

الفرق بين:

Screen: ترسم الواجهة.
ViewModel: يدير المنطق.
Model: يخزن البيانات.

وهذا هو أول تطبيق عملي لمبدأ فصل المسؤوليات (Separation of Concerns). */