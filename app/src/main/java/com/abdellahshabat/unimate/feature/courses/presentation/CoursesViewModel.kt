package com.abdellahshabat.unimate.feature.courses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdellahshabat.unimate.feature.courses.domain.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val repository: CoursesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CoursesState())

    val state: StateFlow<CoursesState> = _state

    init {
        loadCourses()
    }

    private fun loadCourses() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            val result = repository.getCourses()

            _state.value = if (result.isSuccess) {

                CoursesState(
                    isLoading = false,
                    courses = result.getOrDefault(emptyList())
                )

            } else {

                CoursesState(
                    isLoading = false,
                    error = result.exceptionOrNull()?.message
                        ?: "Failed to load courses"
                )
            }
        }
    }
}