package pl.cyganki.utils.swagger

import org.springframework.context.annotation.Import
import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.Target

/**
 * This indicates that Swagger configured for e-Arbiter should
 * be available for specified module. If you want to disable it for
 * specified profile, set e-arbiter.swagger.enabled property on false
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SwaggerConfiguration::class, SwaggerController::class)annotation class EnableArbiterSwagger