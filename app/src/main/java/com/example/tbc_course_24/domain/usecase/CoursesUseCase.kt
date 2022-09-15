package com.example.tbc_course_24.domain.usecase

import com.example.tbc_course_24.domain.repository.CourseRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoursesUseCase @Inject constructor(private val courseRepository: CourseRepository ) {

    suspend fun invoke() = courseRepository.getCourses()

}