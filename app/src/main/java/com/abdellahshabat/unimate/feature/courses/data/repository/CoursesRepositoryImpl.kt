package com.abdellahshabat.unimate.feature.courses.data.repository

import com.abdellahshabat.unimate.feature.courses.domain.repository.CoursesRepository
import com.abdellahshabat.unimate.feature.courses.presentation.CourseUiModel
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor() : CoursesRepository {

    override suspend fun getCourses(): Result<List<CourseUiModel>> {

        return try {

            val courses = listOf(
                CourseUiModel(
                    id = "1",
                    name = "Distributed Computing",
                    code = "DC401",
                    instructor = "Instructor"
                ),
                CourseUiModel(
                    id = "2",
                    name = "Smart Device Applications",
                    code = "SDA402",
                    instructor = "Instructor"
                )
            )

            Result.success(courses)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}