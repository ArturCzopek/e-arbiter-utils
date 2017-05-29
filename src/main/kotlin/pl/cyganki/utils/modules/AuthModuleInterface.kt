package pl.cyganki.utils.modules

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import pl.cyganki.utils.security.User

@FeignClient("authentication-module")
@ConditionalOnProperty(value = "e-arbiter.modules.enabled", matchIfMissing = true)
interface AuthModuleInterface {

    @RequestMapping("/api/user")
    fun getUser(@RequestHeader("oauth_token") token: String): User

    @RequestMapping("/api/token")
    fun getToken(): String
}