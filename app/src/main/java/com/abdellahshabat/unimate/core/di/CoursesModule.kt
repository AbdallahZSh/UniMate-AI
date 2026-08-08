package com.abdellahshabat.unimate.core.di

import com.abdellahshabat.unimate.feature.courses.data.repository.CoursesRepositoryImpl
import com.abdellahshabat.unimate.feature.courses.domain.repository.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoursesModule {

    @Binds
    @Singleton
    abstract fun bindCoursesRepository(
        impl: CoursesRepositoryImpl
    ): CoursesRepository
}