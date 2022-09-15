package com.example.tbc_course_24.domain.repository

import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.common.Resource
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
        suspend fun getCourses(): Flow<Resource<CoursesModel>>
}