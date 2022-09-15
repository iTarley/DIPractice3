package com.example.tbc_course_24.ui.main.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_course_24.common.BaseViewModel

import com.example.tbc_course_24.domain.model.CoursesModel
import com.example.tbc_course_24.domain.usecase.CoursesUseCase
import com.example.tbc_course_24.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val coursesUseCase: CoursesUseCase
) : BaseViewModel<CoursesModel>() {

    suspend fun getResponse(){
        resetState()
        responseHandler(coursesUseCase.invoke())
    }




}