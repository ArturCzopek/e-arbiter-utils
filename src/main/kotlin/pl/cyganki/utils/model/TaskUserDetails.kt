package pl.cyganki.utils.model

data class TaskUserDetails(
        var taskId: String = "",
        var earnedPoints: Int = 0,
        var userAttempts: Int = 0,
        var maxAttempts: Int? = null
)