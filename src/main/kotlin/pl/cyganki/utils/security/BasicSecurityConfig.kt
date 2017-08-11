package pl.cyganki.utils.security

import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Configuration for Security. It allows to retrieve requests only from client and hystrix dashboard
 * It can be used in application by using proper annotation/property.
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterBasicSecurity
 */
@Configuration
@ConditionalOnProperty(value = "e-arbiter.basic-security.enabled", matchIfMissing = true)
open class BasicSecurityConfig(
        @Value("\${e-arbiter.clientUrl}") private val clientUrl: String,
        @Value("\${e-arbiter.proxyUrl}") private val proxyUrl: String,
        @Value("\${e-arbiter.monitoringUrl}") private val monitoringUrl: String
) {

    @Bean
    open fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.apply {
                    addMapping("/**")
                            .allowedOrigins(proxyUrl, clientUrl)
                            .allowedHeaders("*")
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                            .maxAge(3600)

                    addMapping("/hystrix.stream**")
                            .allowedOrigins(monitoringUrl)
                            .allowedHeaders("*")
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                            .maxAge(3600)
                }

                logger.info("Allowed AJAX origins: $clientUrl, $proxyUrl")
                logger.info("Allowed hystrix for: $monitoringUrl")
            }
        }
    }

    companion object: KLogging()
}