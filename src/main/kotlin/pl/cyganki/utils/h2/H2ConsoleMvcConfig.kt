package pl.cyganki.utils.h2

import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


/**
 * Mvc config for access to H2 database console from microservice level
 * You also need to configure security for this case in your module by yourself.
 * THIS CLASS ADDS IT ONLY TO MVC CONFIG!!
 * You have to do 2 things to enable it:
 *
 * 1. Use proper annotation (below)
 * 2. Set spring.h2.console.enabled as true
 *
 * @see pl.cyganki.utils.annotation.EnableH2Console
 */
@ConditionalOnProperty(value = "spring.h2.console.enabled", matchIfMissing = false)
@Configuration
open class H2ConsoleMvcConfig(
        @Value("\${spring.h2.console.path}") private var dbConsoleUrl: String
) : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController(dbConsoleUrl).setViewName("db-console")
        logger.info("Initialized view controller for h2 console. Path: $dbConsoleUrl")
    }

    companion object: KLogging()
}