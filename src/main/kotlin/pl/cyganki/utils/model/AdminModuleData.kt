package pl.cyganki.utils.model

data class AdminModuleData(
        var moduleName: String = "",                // global val - e-arbiter.service-name
        var port: String = "",                      // global val - server.port
        var profiles: List<String> = listOf(),      // global val - profiles
        var javaVersion: String = "",               // env - java.version
        var healthStatus: String = "",              // health - status
        var logs: String = "",                      // logfile - whole content
        var memory: Long = 0,                       // metrics - mem
        var memoryFree: Long = 0,                   // metrics - mem.free
        var heapInit: Long = 0,                     // metrics - heap.init
        var heapUsed: Long = 0                      // metrics - heap.used
)