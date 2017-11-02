package pl.cyganki.utils.model.tournamentresults

data class UserTournamentResults(
        var userName: String = "",
        var position: Int = 0,
        var taskResults: List<SingleTaskResult> = listOf(),
        var summaryPoints: Long = 0
)