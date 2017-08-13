package pl.cyganki.utils.resolver

import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Class where all resolvers are added
 * It can be enabled in app by proper annotation.
 *
 * @see pl.cyganki.annotation.EnableArbiterResolvers
 */
@Configuration
class ResolverConfig(
        val userResolver: UserResolver
) : WebMvcConfigurerAdapter() {

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers += userResolver
    }
}