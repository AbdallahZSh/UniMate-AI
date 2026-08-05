package com.abdellahshabat.unimate.feature.auth.domain.repository
//هذا الـ Interface يحدد الوظائف التي يحتاجها التطبيق دون معرفة ما إذا كانت Firebase أو أي خدمة أخرى هي التي تنفذها.
interface AuthRepository {
    suspend fun login(
        email: String,
        password: String
    ): Result<Unit>

    suspend fun register(
        email: String,
        password: String
    ): Result<Unit>

    suspend fun logout()

    fun currentUserId(): String?
}