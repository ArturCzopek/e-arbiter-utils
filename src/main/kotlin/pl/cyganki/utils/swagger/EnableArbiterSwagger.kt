package pl.cyganki.utils.swagger

import org.springframework.context.annotation.Import

/**
 * This indicates that Swagger configured for e-Arbiter should
 * be available for specified module. If you want to disable it for
 * specified profile, set e-arbiter.swagger.enabled property on false
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(SwaggerConfiguration::class, SwaggerController::class)
annotation class EnableArbiterSwagger