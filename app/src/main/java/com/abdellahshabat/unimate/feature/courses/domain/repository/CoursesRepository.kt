package com.abdellahshabat.unimate.feature.courses.domain.repository

import com.abdellahshabat.unimate.feature.courses.presentation.CourseUiModel

interface CoursesRepository {

    suspend fun getCourses(): Result<List<CourseUiModel>>
}