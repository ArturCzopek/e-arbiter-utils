package pl.cyganki.utils.modules

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import pl.cyganki.utils.GlobalValues
import pl.cyganki.utils.security.dto.User

/**
 * Interface which allows us to communicate with AuthModule
 * You can inject it as a normal bean
 * To enable it, you need to turn on modules by proper property/annotation
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterModules
 *
 * This module probably has more endpoints. You can check it in
 * API.md file in main repo. However, there should be endpoints whose will be
 * USED BY OTHER MODULES OR GATEWAY FILTERS, not directly by web -> gateway -> module
 * which are only filtered by API Gateway
 *
 * @link https://github.com/ArturCzopek/e-arbiter/blob/master/API.md
 */
@FeignClient("authentication-module")
@ConditionalOnProperty(value = "e-arbiter.modules.enabled", matchIfMissing = true)
interface AuthModuleInterface {

    @GetMapping("/api/user")
    fun getUser(@RequestHeader(GlobalValues.AUTH_TOKEN) token: String): User

    @GetMapping("/api/me")
    fun getUserFromRequest(user: User): User

    @GetMapping("/api/token")
    fun getToken(): String

}