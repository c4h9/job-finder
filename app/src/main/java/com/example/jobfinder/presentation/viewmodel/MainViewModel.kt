package com.example.jobfinder.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _isFirstLaunch = MutableStateFlow<Boolean?>(null)
    val isLogin: StateFlow<Boolean?> get() = _isFirstLaunch

    init {

    }
}