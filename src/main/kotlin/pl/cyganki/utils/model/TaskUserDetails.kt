package pl.cyganki.utils.model

data class TaskUserDetails(
        val taskId: Long,
        val pointsReceived: Float,
        val userAttempts: Int,
        val maxAttempts: Int
)