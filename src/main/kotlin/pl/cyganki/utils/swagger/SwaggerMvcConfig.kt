package pl.cyganki.utils.swagger

import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import pl.cyganki.utils.h2.H2ConsoleMvcConfig

/**
 * @Author arturczopek
 * @Date 08-07-2017
 */
/**
 * Mvc config for access to Swagger UI from microservice level
 * You also need to configure security for this case in your module by yourself.
 * THIS CLASS ADDS IT ONLY TO MVC CONFIG!!
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterSwagger
 */
@ConditionalOnProperty(value = "spring.h2.console.enabled", matchIfMissing = false)
@Configuration
open class SwaggerMvcConfig(
        @Value("\${e-arbiter.swagger.path:rest-api}") var swaggerUrl: String
) : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/$swaggerUrl").setViewName("swaggerUrlAlias")
        registry.addViewController("/swagger-ui.html").setViewName("swaggerUrl")
        H2ConsoleMvcConfig.logger.info("Initialized view controller for Swagger. Alias Path: /$swaggerUrl")
    }

    companion object: KLogging()
}