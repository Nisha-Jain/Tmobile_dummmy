package com.example.tmobile.domain.usecase

import com.example.tmobile.domain.repo.AuthRepository
import com.example.tmobile.domain.response.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<LoginResponse> {
        return repository.login(email, password)
    }
}