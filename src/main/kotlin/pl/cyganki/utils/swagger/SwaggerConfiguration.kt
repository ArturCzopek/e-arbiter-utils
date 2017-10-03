package pl.cyganki.utils.swagger

import com.google.common.base.Predicates.or
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Configuration for Swagger UI
 * It can be used in application by using proper annotation/property.
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterSwagger
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = "e-arbiter.swagger.enabled", matchIfMissing = true)
@ConfigurationProperties(prefix = "e-arbiter.swagger")
class SwaggerConfiguration {

    var title: String = "e-Arbiter"
    var version: String = "1.0.0-SNAPSHOT"
    var description: String = "e-Arbiter"
    var contactName: String = "cyganki"
    var contactAddress: String = "artur@simplecoding.pl"
    var contactUrl: String = "http://simplecoding.pl"

    private val API_REGEX = "/api.*"
    private val ADMIN_REGEX = "/admin.*"

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .contact(Contact(contactName, contactUrl, contactAddress))
                .build()
    }

    private fun paths() = or(
            regex(API_REGEX),
            regex(ADMIN_REGEX)
    )
}