package com.example.tmobile.presentation.components.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {
    private var _showDialog = MutableStateFlow(false)
    val showDialog: MutableStateFlow<Boolean> = _showDialog

    fun showDialog() {
        _showDialog.value = true
    }
}