package pl.cyganki.utils.admin

data class AdminServiceData(
        var serviceName: String = "",
        var port: String = "",
        var profiles: List<String> = listOf(),
        var javaVersion: String = "",
        var logFilePath: String = "",
        var memoryFree: String = "",
        var memoryTotal: String = "",
        var memoryMax: String = "",
        var health: String = ""
)
