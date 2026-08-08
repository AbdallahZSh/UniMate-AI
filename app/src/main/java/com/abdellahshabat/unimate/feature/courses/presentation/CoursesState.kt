package com.abdellahshabat.unimate.feature.courses.presentation

data class CoursesState(
    val isLoading: Boolean = false,
    val courses: List<CourseUiModel> = emptyList(),
    val error: String? = null
)