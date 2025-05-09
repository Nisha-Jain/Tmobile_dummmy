package com.example.tmobile.data.repository

import com.example.tmobile.data.ApiService
import com.example.tmobile.data.LoginRequest
import com.example.tmobile.domain.repo.AuthRepository
import com.example.tmobile.domain.response.LoginResponse
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) : AuthRepository {
    override suspend fun login(email: String, password: String): Result<LoginResponse> {
        return try {
            val response = apiService.login(LoginRequest(email, password))
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Login Failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}