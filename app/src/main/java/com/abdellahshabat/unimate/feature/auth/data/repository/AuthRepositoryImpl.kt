package com.abdellahshabat.unimate.feature.auth.data.repository

import com.abdellahshabat.unimate.feature.auth.data.datasource.FirebaseAuthDataSource
import com.abdellahshabat.unimate.feature.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(

    private val dataSource: FirebaseAuthDataSource

) : AuthRepository {


    override suspend fun login(email: String, password: String): Result<Unit> {

        return try {
            dataSource.login(email, password)
            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun register(email: String, password: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override fun currentUserId(): String? {
        TODO("Not yet implemented")
    }

}