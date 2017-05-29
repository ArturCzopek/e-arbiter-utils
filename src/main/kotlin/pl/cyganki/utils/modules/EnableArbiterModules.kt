package pl.cyganki.utils.modules

import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Import

/**
 * This indicates that communication between modules is available
 * In this case, you can use every interface from
 * {@link pl.cyganki.utils.modules.clients}
 *
 * If you want to disable it for specified profile,
 * set e-arbiter.modules.enabled property on false
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(AuthModuleInterface::class)
@EnableFeignClients
annotation class EnableArbiterModules