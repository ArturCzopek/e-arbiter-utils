package pl.cyganki.utils.modules

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import pl.cyganki.utils.model.tournamentresults.UsersTasksList

/**
 *
 * Interface which allows us to communicate with Executor Module
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
@FeignClient("tournament-module")
@ConditionalOnProperty(value = "e-arbiter.modules.enabled", matchIfMissing = true)
interface TournamentModuleInterface {

    // PRIVATE

    @GetMapping("/inner/users-tasks-list/{id}")
    fun getUsersTasksList(@PathVariable("id") tournamentId: String): UsersTasksList
}