package com.example.tbc_course_24.ui.main.main

import androidx.lifecycle.viewModelScope
import com.example.tbc_course_24.common.BaseViewModel
import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.domain.usecase.CoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val coursesUseCase: CoursesUseCase
) : BaseViewModel<CoursesModel>() {

    private val _course: MutableStateFlow<CoursesModel> = MutableStateFlow(CoursesModel(emptyList(),
        emptyList()))
    val course = _course.asStateFlow()


    fun getCourses(){
        viewModelScope.launch {
            resetState()
            responseHandler(coursesUseCase.invoke()){
                _course.value = _course.value.copy(
                    activeCourses = _flow.value.data?.activeCourses?.map { it },
                    newCourses = _flow.value.data?.newCourses?.map { it }
                )
            }
        }
    }





}