package pl.cyganki.utils.model.tournamentresults

data class UsersTasksList(
        val users: List<Long> = listOf(),
        val tasks: List<String> = listOf()
)