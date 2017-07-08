package pl.cyganki.utils.annotation

import org.springframework.context.annotation.Import
import pl.cyganki.utils.swagger.SwaggerConfiguration
import pl.cyganki.utils.swagger.SwaggerController
import pl.cyganki.utils.swagger.SwaggerMvcConfig

/**
 * This indicates that Swagger configured for e-Arbiter should
 * be available for specified module. If you want to disable it for
 * specified profile, set e-arbiter.swagger.enabled property on false
 *
 * @see pl.cyganki.utils.swagger
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(SwaggerConfiguration::class, SwaggerController::class, SwaggerMvcConfig::class)
annotation class EnableArbiterSwagger