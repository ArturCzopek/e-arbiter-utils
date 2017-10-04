package pl.cyganki.utils.model

data class TaskUserDetails(
        val taskId: String,
        val earnedPoints: Int,
        val userAttempts: Int,
        val maxAttempts: Int?
)