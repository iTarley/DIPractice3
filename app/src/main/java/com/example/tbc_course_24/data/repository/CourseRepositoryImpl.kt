package com.example.tbc_course_24.data.repository

import com.example.tbc_course_24.data.services.ApiInterface
import com.example.tbc_course_24.domain.repository.CourseRepository
import com.example.tbc_course_24.common.RequestHandler
import com.example.tbc_course_24.common.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor (private val api: ApiInterface):
    RequestHandler(),
    CourseRepository {

    override suspend fun getCourses() = flow {
        emit(Resource.loading())
        emit(apiCall { api.getResponse() })
    }
}

