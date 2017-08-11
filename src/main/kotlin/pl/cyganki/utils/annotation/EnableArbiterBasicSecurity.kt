package pl.cyganki.utils.annotation

import org.springframework.context.annotation.Import
import pl.cyganki.utils.security.BasicSecurityConfig

/**
 * Annotations which will add basic security to application.
 * It means that AJAX requests to modules are available only from client and API Gateway.
 * Also, request for hystrix.stream are available for monitoring service.
 * If you want to disable it for specified profile, set e-arbiter.basic-security.enabled property on false.
 * By default, it's true after adding this annotation
 *
 * @see pl.cyganki.utils.security
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(BasicSecurityConfig::class)
annotation class EnableArbiterBasicSecurity