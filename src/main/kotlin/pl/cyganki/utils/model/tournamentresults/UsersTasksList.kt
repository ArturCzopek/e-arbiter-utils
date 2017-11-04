package pl.cyganki.utils.model.tournamentresults

data class UsersTasksList(
        var users: List<Long> = listOf(),
        var tasks: List<String> = listOf()
)