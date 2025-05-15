package com.example.composefisrt.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/*
项目名称：Compose Fisrt
包名： composefisrt
作者： bobowg
日期： 2025/5/4 时间：10:54
备注：
*/

class MyViewModel : ViewModel() {
    private val _nameState = MutableStateFlow("3")
    val nameState = _nameState.asStateFlow()
    fun loadName() {
        viewModelScope.launch {
            Log.d("Effects", "loadName()")
            delay(1500)
            _nameState.update { "bobowg" }
        }
    }

    fun addToName() {
        _nameState.update { "new" + it }
    }
}

