package pl.cyganki.utils.modules.tournamentresult.dto

import pl.cyganki.utils.model.Language

data class CodeTaskResultDto(
        var userId: Long = 0,
        var tournamentId: String = "",
        var taskId: String = "",
        var earnedPoints: String = "",
        var language: Language = Language.C11,
        var resultCode: String = "",
        var executionTime: Long = 0
)