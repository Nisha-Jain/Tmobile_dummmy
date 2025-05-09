package com.example.tmobile.presentations.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobile.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private var loginUseCase: LoginUseCase
) : ViewModel() {
    private var _showDialog = MutableStateFlow(false)
    val showDialog: MutableStateFlow<Boolean> = _showDialog

    var errorMessage = mutableStateOf("")
        private set


    fun showDialog(text: String) {
        _showDialog.value = true
        errorMessage.value = text

    }

    fun login(email: String, password: String, onSignInClick: () -> Unit = {}) {
        viewModelScope.launch {
            loginUseCase(email, password).onSuccess {
                Log.d("ddd", "Hello Nisha")
                onSignInClick()

            }.onFailure {
                _showDialog.value = true
                errorMessage.value = it.message.toString()

                Log.d("ddd", "Error ${it.message}")
            }

        }
    }


}
