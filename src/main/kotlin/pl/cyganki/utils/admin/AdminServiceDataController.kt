package pl.cyganki.utils.admin

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller for fetching data about service
 * It can be used in application by using proper annotation/property.
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterAdminServiceData
 */

@RestController
@RequestMapping("/admin/service-data")
@ConditionalOnProperty(value = "e-arbiter.admin.service-data.enabled", matchIfMissing = true)
class AdminServiceDataController {

    @Value("\${e-arbiter.service-name}")
    lateinit var serviceName: String

    @Value("\${server.port}")
    lateinit var port: String

    @Value("\${spring.profiles.active}")
    lateinit var profiles: List<String>

    @Value("\${logging.file}")
    lateinit var logFilePath: String

    @GetMapping(value = *arrayOf("/", ""))
    fun getModuleData(): AdminServiceData = AdminServiceData(
            serviceName,
            port,
            profiles,
            System.getProperty("java.version"),
            logFilePath,
            "${Math.round(Runtime.getRuntime().freeMemory() / 10e6)} Mb",
            "${Math.round(Runtime.getRuntime().totalMemory() / 10e6)} Mb",
            "${Math.round(Runtime.getRuntime().maxMemory() / 10e6)} Mb",
            "OK"
    )
}