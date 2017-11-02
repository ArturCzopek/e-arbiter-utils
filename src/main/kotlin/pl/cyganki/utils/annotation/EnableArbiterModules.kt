package pl.cyganki.utils.annotation

import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Import
import pl.cyganki.utils.modules.AuthModuleInterface
import pl.cyganki.utils.modules.ExecutorModuleInterface
import pl.cyganki.utils.modules.TournamentResultsModuleInterface

/**
 * This indicates that communication between modules is available by proper interfaces.
 *
 * If you want to disable it for specified profile,
 * set e-arbiter.modules.enabled property on false
 *
 * @see pl.cyganki.utils.modules
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(
        AuthModuleInterface::class,
        ExecutorModuleInterface::class,
        TournamentResultsModuleInterface::class
)
@EnableFeignClients("pl.cyganki.utils.modules")
annotation class EnableArbiterModules
