package pl.cyganki.utils.model.tournamentresults

data class QuizTaskResultDto(
        var userId: Long = 0,
        var tournamentId: String = "",
        var taskId: String = "",
        var earnedPoints: String = ""
)