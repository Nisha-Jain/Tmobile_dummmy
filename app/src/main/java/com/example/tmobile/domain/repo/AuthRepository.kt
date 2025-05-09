package com.example.tmobile.domain.repo

import com.example.tmobile.domain.response.LoginResponse

interface AuthRepository {
    suspend fun login(email:String, password:String) :Result<LoginResponse>
}