package pl.cyganki.utils.model.tournamentresults

data class UserTournamentResults(
        val userName: String = "",
        var position: Int = 0,
        val taskResults: List<SingleTaskResult> = listOf(),
        val summaryPoints: Long = 0
)