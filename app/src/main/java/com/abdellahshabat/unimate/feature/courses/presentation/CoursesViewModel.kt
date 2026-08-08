package com.abdellahshabat.unimate.feature.courses.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CoursesState())

    val state: StateFlow<CoursesState> = _state

    init {
        loadCourses()
    }

    private fun loadCourses() {

        _state.value = _state.value.copy(
            isLoading = true,
            error = null
        )

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

        _state.value = _state.value.copy(
            isLoading = false,
            courses = courses
        )
    }
}