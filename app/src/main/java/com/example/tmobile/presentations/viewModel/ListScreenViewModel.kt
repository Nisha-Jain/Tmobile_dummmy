package com.example.tmobile.presentations.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor() : ViewModel() {
    private var _showDialog = MutableStateFlow(false)
    val showDialog: MutableStateFlow<Boolean> = _showDialog

    private var _errorMessage = MutableStateFlow("")
    val errorMessage: MutableStateFlow<String> = _errorMessage


    fun showDialog() {
        _showDialog.value = true
    }



}
