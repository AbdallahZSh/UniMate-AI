package com.abdellahshabat.unimate.core.di

import android.content.Context
import com.abdellahshabat.unimate.core.datastore.PreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//@Module
// يعني:هذا الملف مسؤول عن توفير الـ Dependencies.
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//    @Provides يعني:
//    إذا احتاج أي كلاس PreferenceRepository، أنشئه بهذه الطريقة.
//    @Singleton يعنييعني:
//أنشئ نسخة واحدة فقط طوال عمر التطبيق.
//      بدلًا من إنشاء Repository جديد في كل شاشة.
//    @ApplicationContext
//يجلب Context الخاص بالتطبيق وليس بالنشاط (Activity)، وهذا هو الخيار الصحيح مع DataStore.
    @Provides
    @Singleton
    fun providePreferenceRepository(
        @ApplicationContext context: Context
    ): PreferenceRepository {

        return PreferenceRepository(context)

    }

}