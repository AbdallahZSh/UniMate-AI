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

        return try {

            dataSource.register(email, password)
            Result.success(Unit)

        } catch (e: Exception) {

            Result.failure(e)

        }
    }

    override suspend fun logout() {

        dataSource.logout()

    }

    override fun currentUserId(): String? {
        //وهذه سترجع:
        //UID إذا كان المستخدم مسجلاً، أو:
        //null إذا لم يكن هناك مستخدم.
        return dataSource.currentUserId()

    }

}